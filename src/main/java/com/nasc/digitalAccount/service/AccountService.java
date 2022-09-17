package com.nasc.digitalAccount.service;

import com.nasc.digitalAccount.dto.AccountDto;
import com.nasc.digitalAccount.dto.TransferDto;
import com.nasc.digitalAccount.exception.AccountException;
import com.nasc.digitalAccount.exception.ResourceNotFoundException;
import com.nasc.digitalAccount.model.Account;
import com.nasc.digitalAccount.model.Client;
import com.nasc.digitalAccount.repository.AccountRepository;
import com.nasc.digitalAccount.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    private AccountDto convertToDto(Account account) {
        return modelMapper.map(account, AccountDto.class);
    }

    private Account convertToEntity(AccountDto accountDto) {
        return modelMapper.map(accountDto, Account.class);
    }

    // create account
    public Account createAccount(final AccountDto accountDto) {
        // TO DO : password encryption
        return accountRepository.save(convertToEntity(accountDto));
    }

    // list accounts
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    // consult account
    public Account findAccount(final String accountNumber, final String agency) {
        try {
            return accountRepository.findByAgencyAndAccountNumber(agency, accountNumber);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Account do not exists");
        }
    }

    // consult account by ID
    public Account findAccountById(final Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account do not exists"));
    }

    // balance account
    public BigDecimal getBalanceAccount(final String accountNumber, final String agency) {
        Account account = findAccount(accountNumber, agency);
        return account.getBalance();
    }

    // find account by client name
    public Account findAccountByName(final String name) {
        Optional<Client> client = clientRepository.findByName(name);
        Optional<Account> account;
        if (client.isPresent()) {
            account = accountRepository.findById(client.get().getId());
        } else {
            throw new ResourceNotFoundException("Account not found for this name:" + name);
        }
        return account.orElseThrow(() -> new ResourceNotFoundException("Account not found for this name:" + name));
    }

    // Deposit
    public Account deposit(String agency, String accountNumber, BigDecimal amount) {
        Account account = findAccount(accountNumber, agency);
        account.setBalance(account.getBalance().add(amount));
        return accountRepository.save(account);
    }

    // withdraw
    private Account withdraw(String agency, String accountNumber, BigDecimal amount) {
        Account account = findAccount(accountNumber, agency);
        if (amount.doubleValue() <= 0.0 || account.getBalance().compareTo(amount) < 0) {
            throw new AccountException("Not enough funds on balance");
        }
        account.setBalance(account.getBalance().subtract(amount));
        return accountRepository.save(account);
    }

    // transfer to another account
    public List<Account> transfer(TransferDto transferDto) {
        deposit(transferDto.getDestinationAgency(), transferDto.getDestinationAccountNumber(), transferDto.getAmount());
        withdraw(transferDto.getSourceAgency(), transferDto.getSourceAccountNumber(), transferDto.getAmount());
        List<Account> accounts = new ArrayList<>();
        accounts.add(findAccount(transferDto.getDestinationAgency(), transferDto.getDestinationAccountNumber()));

        Account destinationAccount = findAccount(transferDto.getSourceAgency(), transferDto.getSourceAccountNumber());
        accounts.add(destinationAccount);

        // gerar extract

        return accounts;
    }


    // consult account statement

}

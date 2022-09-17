package com.nasc.digitalAccount.repository;

import com.nasc.digitalAccount.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByAgencyAndAccountNumber(String agency, String accountNumber);
}
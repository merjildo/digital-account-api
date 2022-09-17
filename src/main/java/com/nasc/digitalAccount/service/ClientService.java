package com.nasc.digitalAccount.service;

import com.nasc.digitalAccount.dto.ClientDto;
import com.nasc.digitalAccount.exception.ResourceAlreadyExistException;
import com.nasc.digitalAccount.exception.ResourceNotFoundException;
import com.nasc.digitalAccount.model.Client;
import com.nasc.digitalAccount.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ModelMapper modelMapper;

    private ClientDto convertToDto(Client client) {
        return modelMapper.map(client, ClientDto.class);
    }

    private Client convertToEntity(ClientDto employeeDto) {
        return modelMapper.map(employeeDto, Client.class);
    }

    // create new client
    public ClientDto createClient(final ClientDto clientDto) {
        if (emailExists(clientDto.getEmail()) || documentExists(clientDto.getDocument())) {
            throw new ResourceAlreadyExistException("There is an account already using email or document :" + clientDto.getEmail());
        }
        final Client client = clientRepository.save(convertToEntity(clientDto));
        return convertToDto(client);
    }

    // update client
    public ClientDto updateClientInfo(Long id, ClientDto clientDto) {
        Client client = clientRepository.findByEmail(clientDto.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this email:" + clientDto.getEmail()));
        client.setAddress(clientDto.getAddress());
        client.setCellphone(clientDto.getCellphone());
        client.setEmail(clientDto.getEmail());
        client.setName(clientDto.getName());
        client.setDocument(clientDto.getDocument());
        client.setStatus(clientDto.getStatus());
        return convertToDto(clientRepository.save(convertToEntity(clientDto)));
    }

    public void deleteClient(String email) {
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this email:" + email));
        clientRepository.delete(client);
    }

    public ClientDto findByEmail(String email){
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this email:" + email));
        return convertToDto(client);
    }

    public List<ClientDto> findAll(){
        List<Client> clients = clientRepository.findAll();
        return clients.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public ClientDto findByName(String name){
        Client client = clientRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this name:" + name));
        return convertToDto(client);
    }

    public ClientDto findByDocument(String document){
        Client client = clientRepository.findByDocument(document)
                .orElseThrow(() -> new ResourceNotFoundException("Client not found for this document:" + document));
        return convertToDto(client);
    }

    private boolean emailExists(final String email) {
        return clientRepository.findByEmail(email).isPresent();
    }

    private boolean documentExists(final String document) {
        return clientRepository.findByDocument(document).isPresent();
    }
}

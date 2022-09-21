package com.nasc.digitalAccount.controller;

import com.nasc.digitalAccount.dto.ClientDto;
import com.nasc.digitalAccount.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Registration new client account", description = "Allows new client registration")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created"),
            @ApiResponse(responseCode = "409", description = "Conflict - The resource already exists")
    })
    public ClientDto createClient(@Valid @RequestBody ClientDto clientDto) {
        return clientService.createClient(clientDto);
    }

    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update client account", description = "Allows new client updating")
    public ClientDto updateClient(@PathVariable(value = "id") Long id, @Valid @RequestBody ClientDto clientDto) {
        return clientService.updateClientInfo(id, clientDto);
    }

    @DeleteMapping("/clients/{email}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Remove client account", description = "Allows to client removing")
    public void removeClient(@PathVariable(value = "email") String email) {
        clientService.deleteClient(email);
    }

    @GetMapping("/clients/findByEmail/{email}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find client by email", description = "Get client by email")
    public ClientDto findByEmail(@PathVariable(value = "email") String email) {
        return clientService.findByEmail(email);
    }

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find all clients", description = "Get all clients")
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/clients/findByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find client by name", description = "Get client by name")
    public ClientDto findByName(@PathVariable(value = "name") String name) {
        return clientService.findByName(name);
    }

    @GetMapping("/clients/findByDocument/{document}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find client by CPF/CNPJ", description = "Get client by CPF/CNPJ")
    public ClientDto findByDocument(@PathVariable(value = "document") String document) {
        return clientService.findByDocument(document);
    }

}

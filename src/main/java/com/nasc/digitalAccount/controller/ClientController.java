package com.nasc.digitalAccount.controller;

import com.nasc.digitalAccount.dto.ClientDto;
import com.nasc.digitalAccount.service.ClientService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Registration new client account", notes = "Allows new client registration")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created"),
            @ApiResponse(code = 409, message = "Conflict - The resource already exists")
    })
    public ClientDto createClient(@Valid @RequestBody ClientDto clientDto) {
        return clientService.createClient(clientDto);
    }

    @PutMapping("/clients/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Update client account", notes = "Allows new client updating")
    public ClientDto updateClient(@PathVariable(value = "id") Long id, @Valid @RequestBody ClientDto clientDto) {
        return clientService.updateClientInfo(id, clientDto);
    }

    @DeleteMapping("/clients/{email}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Remove client account", notes = "Allows to client removing")
    public void removeClient(@PathVariable(value = "email") String email) {
        clientService.deleteClient(email);
    }

    @GetMapping("/clients/findByEmail/{email}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find client by email", notes = "Get client by email")
    public ClientDto findByEmail(@PathVariable(value = "email") String email) {
        return clientService.findByEmail(email);
    }

    @GetMapping("/clients")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find all clients", notes = "Get all clients")
    public List<ClientDto> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/clients/findByName/{name}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find client by name", notes = "Get client by name")
    public ClientDto findByName(@PathVariable(value = "name") String name) {
        return clientService.findByName(name);
    }

    @GetMapping("/clients/findByDocument/{document}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Find client by CPF/CNPJ", notes = "Get client by CPF/CNPJ")
    public ClientDto findByDocument(@PathVariable(value = "document") String document) {
        return clientService.findByDocument(document);
    }

}

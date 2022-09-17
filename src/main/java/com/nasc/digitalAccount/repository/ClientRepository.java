package com.nasc.digitalAccount.repository;

import com.nasc.digitalAccount.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);
    Optional<Client> findByName(String name);
    Optional<Client> findByDocument(String document);
}
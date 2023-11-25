package com.example.backend_.service;

import com.example.backend_.model.Client;
import com.example.backend_.model.Payment;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client add(Client client);

    Optional<Client> findById(Long id);

    List<Client> findAll();

    void deleteById(Long id);

    Client update(Client client);

    Optional<List<Payment>> getPayments(Long id);
}

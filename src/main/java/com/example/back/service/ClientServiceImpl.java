package com.example.backend_.service;

import com.example.backend_.model.Client;
import com.example.backend_.model.Payment;
import com.example.backend_.repository.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public Client add(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Optional<List<Payment>> getPayments(Long id) {
        return clientRepository.findById(id).map(Client::getPayments).map(List::copyOf);
    }
}

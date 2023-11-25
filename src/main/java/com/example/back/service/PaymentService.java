package com.example.backend_.service;

import com.example.backend_.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    Payment add(Payment payment, Long clientId, Long projectId);

    Optional<Payment> findById(Long id);

    List<Payment> findAll();

    void deleteById(Long id);

    Payment update(Payment payment);

}

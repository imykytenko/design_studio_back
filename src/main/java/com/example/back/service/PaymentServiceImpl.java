package com.example.backend_.service;

import com.example.backend_.model.Payment;
import com.example.backend_.repository.ClientRepository;
import com.example.backend_.repository.PaymentRepository;
import com.example.backend_.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final ClientRepository clientRepository;
    private final ProjectRepository projectRepository;

    @Override
    @Transactional
    public Payment add(Payment payment, Long clientId, Long projectId) {
        payment.setProject(projectRepository.findById(projectId).orElseThrow(IllegalArgumentException::new));
        payment.setClient(clientRepository.findById(clientId).orElseThrow(IllegalArgumentException::new));
        return paymentRepository.save(payment);
    }

    @Override
    public Optional<Payment> findById(Long id) {
        return paymentRepository.findById(id);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        paymentRepository.deleteById(id);
    }

    @Override
    public Payment update(Payment payment) {
        return paymentRepository.save(payment);
    }
}

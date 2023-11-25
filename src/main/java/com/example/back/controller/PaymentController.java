package com.example.backend_.controller;

import com.example.backend_.controller.dto.payment.PaymentCreationDto;
import com.example.backend_.controller.dto.payment.PaymentDto;
import com.example.backend_.controller.dto.payment.PaymentUpdateDto;
import com.example.backend_.controller.mapper.PaymentMapper;
import com.example.backend_.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class PaymentController {

    private final PaymentService paymentService;
    private final PaymentMapper paymentMapper;

    @PostMapping("/add")
    public ResponseEntity<PaymentDto> add(@RequestBody PaymentCreationDto paymentDto) {
        var payment = paymentService.add(paymentMapper.toEntity(paymentDto), paymentDto.getClientId(), paymentDto.getProjectId());
        return new ResponseEntity<>(paymentMapper.toDto(payment), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDto> findById(@PathVariable Long id) {
        return ResponseEntity.of(paymentService.findById(id).map(paymentMapper::toDto));
    }

    @GetMapping
    public List<PaymentDto> getPayments() {
        return paymentService.findAll().stream().map(paymentMapper::toDto).toList();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PaymentDto> updatePayment(@RequestBody PaymentUpdateDto paymentDto, @PathVariable Long id) {
        return ResponseEntity.of(paymentService.findById(id)
                .map(payment -> paymentMapper.partialUpdate(paymentDto, payment))
                .map(paymentService::update)
                .map(paymentMapper::toDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        paymentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

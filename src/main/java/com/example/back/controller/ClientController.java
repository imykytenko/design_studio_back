package com.example.backend_.controller;

import com.example.backend_.controller.dto.client.ClientCreationDto;
import com.example.backend_.controller.dto.client.ClientDto;
import com.example.backend_.controller.dto.client.ClientUpdateDto;
import com.example.backend_.controller.dto.payment.PaymentDto;
import com.example.backend_.controller.mapper.ClientMapper;
import com.example.backend_.controller.mapper.PaymentMapper;
import com.example.backend_.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
@CrossOrigin(origins = "http://localhost:5173")
public class ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;
    private final PaymentMapper paymentMapper;

    @PostMapping("/add")
    public ResponseEntity<ClientDto> add(@RequestBody ClientCreationDto clientDto) {
        var client = clientService.add(clientMapper.toEntity(clientDto));
        return new ResponseEntity<>(clientMapper.toDto(client), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDto> findById(@PathVariable Long id) {
        return ResponseEntity.of(clientService.findById(id).map(clientMapper::toDto));
    }

    @GetMapping
    public List<ClientDto> findAll() {
        return clientService.findAll().stream().map(clientMapper::toDto).toList();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClientDto> update(@RequestBody ClientUpdateDto clientDto, @PathVariable Long id) {
        return ResponseEntity.of(clientService.findById(id)
                .map(client -> clientMapper.partialUpdate(clientDto, client))
                .map(clientService::update)
                .map(clientMapper::toDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        clientService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/payments")
    public ResponseEntity<List<PaymentDto>> getPayments(@PathVariable Long id) {
        return ResponseEntity.of(clientService.getPayments(id)
                .map(payments -> payments.stream()
                        .map(paymentMapper::toDto).toList()));
    }
}

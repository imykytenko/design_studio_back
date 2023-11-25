package com.example.backend_.controller.dto.payment;

import lombok.Data;

@Data
public class PaymentDto {
    private Long id;
    private Long clientId;
    private Long projectId;
    private Long amount;
    private String paymentMethod;
    private String status;
}

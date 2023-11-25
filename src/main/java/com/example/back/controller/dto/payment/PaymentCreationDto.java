package com.example.backend_.controller.dto.payment;

import lombok.Data;

@Data
public class PaymentCreationDto {
    private Long clientId;
    private Long projectId;
    private Long amount;
    private String paymentMethod;
    private String status;
}

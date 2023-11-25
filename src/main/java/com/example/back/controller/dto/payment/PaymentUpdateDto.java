package com.example.backend_.controller.dto.payment;

import lombok.Data;

@Data
public class PaymentUpdateDto {
    private Long amount;
    private String paymentMethod;
    private String status;
}

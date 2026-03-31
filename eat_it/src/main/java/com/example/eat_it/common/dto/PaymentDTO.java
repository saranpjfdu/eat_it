package com.example.eat_it.common.dto;

import lombok.Data;

@Data
public class PaymentDTO {
    private Long orderId;
    private Double amount;
    private String paymentMethod; // UPI, CARD, COD
    private String paymentStatus; // SUCCESS, FAILED
}
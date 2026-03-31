package com.example.eat_it.common.dto;

import lombok.Data;

@Data
public class DeliveryDTO {
    private Long riderId;
    private String status;
    private Double lat;
    private Double lng;
    private String inputOtp; // Sent by rider when picking up from owner
}
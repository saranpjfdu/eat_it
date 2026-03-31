package com.example.eat_it.common.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDTO {
    private Long orderId;
    private Long userId;
    private Long restaurantId;
    private Long deliveryPersonId;
    private List<OrderItemDTO> items;
    private Double totalAmount;
    private String status; // PLACED, PREPARING, DELIVERED
    private String deliveryAddress;
}
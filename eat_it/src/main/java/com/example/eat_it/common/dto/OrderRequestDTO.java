package com.example.eat_it.common.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDTO {
    private Long userId;
    private Long restaurantId;
    private List<CartItemDTO> items;
    private String deliveryAddress;
}
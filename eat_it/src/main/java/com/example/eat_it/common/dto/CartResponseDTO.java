package com.example.eat_it.common.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartResponseDTO {
    private Long cartId;
    private Long userId;
    private List<CartItemDTO> items;
    private Double totalAmount;
}
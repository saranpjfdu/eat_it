package com.example.eat_it.common.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private Long menuItemId;
    private Integer quantity;
}
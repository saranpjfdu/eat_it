package com.example.eat_it.common.dto;

import lombok.Data;

@Data
public class OrderItemDTO {
    private Long menuItemId;
    private Integer quantity;
    private Double price;
}
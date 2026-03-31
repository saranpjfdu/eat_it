package com.example.eat_it.common.dto;

import lombok.Data;

@Data
public class MenuItemDTO {
    private Long id;
    private Long restaurantId;
    private String name;
    private String description;
    private Double price;
    private Boolean isAvailable;
    private String imageUrl;
}
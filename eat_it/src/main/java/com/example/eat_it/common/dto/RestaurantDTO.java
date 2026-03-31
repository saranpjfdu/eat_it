package com.example.eat_it.common.dto;

import lombok.Data;

@Data
public class RestaurantDTO {
    private Long id;
    private String name;
    private String description;
    private String address;
    private Boolean isOpen;
    private Double rating;
    private Long ownerId;
}
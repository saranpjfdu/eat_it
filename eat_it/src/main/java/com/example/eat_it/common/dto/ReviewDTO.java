package com.example.eat_it.common.dto;

import lombok.Data;

@Data
public class ReviewDTO {
    private Long userId;
    private Long restaurantId;
    private Integer rating;
    private String comment;
}
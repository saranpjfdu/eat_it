package com.example.eat_it.common.dto;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private Boolean success;
    private String message;
    private T data;
}
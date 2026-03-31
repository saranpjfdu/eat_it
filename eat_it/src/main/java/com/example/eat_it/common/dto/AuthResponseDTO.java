package com.example.eat_it.common.dto;

import lombok.Data;

@Data
public class AuthResponseDTO {
    private String token;
    private UserDTO user;
}
package com.example.eat_it.common.dto;

import lombok.Data;

@Data
public class LoginRequestDTO {
    private String email;
    private String password;
}
package com.example.eat_it.auth.controller;


import com.example.eat_it.auth.service.AuthService;
import com.example.eat_it.common.dto.AuthResponseDTO;
import com.example.eat_it.common.dto.LoginRequestDTO;
import com.example.eat_it.common.dto.RegisterRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin // optional (CORS already handled globally)
public class AuthController {

@Autowired
    private  AuthService authService;

    // ✅ REGISTER
    @PostMapping("/register")
    public AuthResponseDTO register(
            @Valid @RequestBody RegisterRequestDTO request
    ) {
        return authService.register(request);
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public AuthResponseDTO login(
            @Valid @RequestBody LoginRequestDTO request
    ) {
        return authService.login(request);
    }
}
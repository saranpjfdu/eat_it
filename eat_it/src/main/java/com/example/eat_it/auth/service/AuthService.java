package com.example.eat_it.auth.service;


import com.example.eat_it.auth.security.JwtService;
import com.example.eat_it.common.dto.AuthResponseDTO;
import com.example.eat_it.common.dto.LoginRequestDTO;
import com.example.eat_it.common.dto.RegisterRequestDTO;
import com.example.eat_it.common.dto.UserDTO;
import com.example.eat_it.user.entity.User;
import com.example.eat_it.user.enums.ApprovalStatus;
import com.example.eat_it.user.enums.Role;
import com.example.eat_it.user.repository.UserRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    // ✅ REGISTER
    public AuthResponseDTO register(RegisterRequestDTO request) {

        // 🔒 Encode password
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // 👤 Create user
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(encodedPassword)
                .role(Role.valueOf(request.getRole().toUpperCase()))
                .build();

        // ✅ Approval logic
        if (user.getRole() == Role.OWNER || user.getRole() == Role.DELIVERY) {
            user.setApprovalStatus(ApprovalStatus.PENDING);
        } else {
            user.setApprovalStatus(ApprovalStatus.APPROVED);
        }

        userRepository.save(user);

        // 🔑 Generate JWT
        String token = jwtService.getToken(user.getEmail(), user.getRole());

        // 📦 Convert to DTO
        UserDTO userDTO = mapToDTO(user);

        return buildResponse(token, userDTO, "User registered successfully");
    }

    // ✅ LOGIN
    public AuthResponseDTO login(LoginRequestDTO request) {

        // 🔐 Authenticate
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        // 👤 Fetch user
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // ❗ Approval check
        if (user.getApprovalStatus() != ApprovalStatus.APPROVED) {
            throw new RuntimeException("User not approved by admin");
        }

        // 🔑 Generate JWT
        String token = jwtService.getToken(user.getEmail(), user.getRole());

        // 📦 DTO
        UserDTO userDTO = mapToDTO(user);

        return buildResponse(token, userDTO, "Login successful");
    }

    // 🔁 Map Entity → DTO
    private UserDTO mapToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setRole(user.getRole().name());
        dto.setApprovalStatus(user.getApprovalStatus().name());
        return dto;
    }

    // 🔁 Common Response Builder
    private AuthResponseDTO buildResponse(String token, UserDTO userDTO, String message) {
        AuthResponseDTO response = new AuthResponseDTO();
        response.setToken(token);
        response.setUser(userDTO);
        return response;
    }
}
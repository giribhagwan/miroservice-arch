package com.example.auth_service.controller;


import com.example.auth_service.dto.RegisterDto;
import com.example.auth_service.dto.TokenDto;
import com.example.auth_service.requests.LoginRequest;
import com.example.auth_service.requests.RegisterRequest;
import com.example.auth_service.services.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
@Log4j2
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterDto> register(@RequestBody RegisterRequest request) {
        log.info("register call inti");
        return ResponseEntity.ok(authService.register(request));
    }
}
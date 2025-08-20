package com.example.auth_service.requests;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String username;
    private String password;
}
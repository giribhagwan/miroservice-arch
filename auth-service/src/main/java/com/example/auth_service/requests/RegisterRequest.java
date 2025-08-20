package com.example.auth_service.requests;

import lombok.Getter;

@Getter
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
}

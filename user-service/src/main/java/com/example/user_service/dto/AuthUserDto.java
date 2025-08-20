package com.example.user_service.dto;

import com.example.user_service.enums.Role;
import lombok.Data;

@Data
public class AuthUserDto {
    private String id;
    private String username;
    private String password;
    private Role role;
}
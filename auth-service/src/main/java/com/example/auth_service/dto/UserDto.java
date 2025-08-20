package com.example.auth_service.dto;


import com.example.auth_service.enums.Role;
import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String username;
    private String password;
    private Role role;
}
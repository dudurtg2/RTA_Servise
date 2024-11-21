package com.example.empresa.security.DTO;

import com.example.empresa.security.UserRole;

public record RegisterDTO(String login, String senha, UserRole role) {

}
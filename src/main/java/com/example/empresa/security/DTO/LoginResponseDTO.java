package com.example.empresa.security.DTO;

import com.example.empresa.emuns.UserRole;
import com.example.empresa.entities.Base;

public record LoginResponseDTO<T>(
    T data,
    String token) {
    
}
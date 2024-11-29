package com.example.empresa.security.DTO;

public record LoginResponseDTO<T>(
    T data,
    String token) {
    
}
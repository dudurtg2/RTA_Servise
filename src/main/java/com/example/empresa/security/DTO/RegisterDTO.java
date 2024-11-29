package com.example.empresa.security.DTO;

import com.example.empresa.emuns.UserRole;

public record RegisterDTO(
    String nome,
    String senha,
    UserRole role,
    String email,
    String telefone,
    String cpf,
    int base,
    String endereco
) {}
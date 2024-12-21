package com.example.empresa.security.DTO;

import java.util.List;

import com.example.empresa.entities.emuns.UserRole;

public record RegisterDTO(
    String nome,
    String senha,
    UserRole role,
    String email,
    String telefone,
    String cpf,
    List<Long> base,
    String endereco
) {}
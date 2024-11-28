package com.example.empresa.security;

public enum UserRole {

    ADMIN("admin"),
    MOTORISTA ("motorista"),
    FUNCIONARIO ("funcionario"),
    SAC("sac"),
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}

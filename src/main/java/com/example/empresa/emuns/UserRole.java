package com.example.empresa.emuns;

public enum UserRole {

    ADMIN("admin"),
    MOTORISTA ("motorista"),
    FUNCIONARIO ("funcionario"),
    ENTREGADOR("entregador"),
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

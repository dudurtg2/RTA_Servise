package com.example.empresa.entities.emuns;

public enum UserRole {

    MOTORISTA("motorista"),
    FUNCIONARIO("funcionario"),
    ADMIN("admin"),
    ENTREGADOR("entregador"),
    SAC("sac"),
    USER("user");

    private final String role;

  
    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

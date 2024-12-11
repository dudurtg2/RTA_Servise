package com.example.empresa.entities.emuns;

public enum UserRole {

    MOTORISTA("motorista"),
    FUNCIONARIO("funcionario"),
    ENTREGADOR("entregador"),
    ADMIN("admin"),
    GERENTE("gerente"),
    SAC("sac"),
    USER("user"),
    RH("rh");

    private final String role;

  
    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}

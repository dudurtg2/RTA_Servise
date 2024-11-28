package com.example.empresa.security;

public enum UserRole {

    ADMIN("admin"),
    USER("user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    UserRole toUpperCase() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toUpperCase'");
    }
}

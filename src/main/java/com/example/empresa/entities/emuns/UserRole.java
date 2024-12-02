package com.example.empresa.entities.emuns;

/**
 * Enumeração que representa os diferentes papéis de usuário no sistema.
 * Cada papel tem um nome associado que é utilizado para identificá-lo.
 */
public enum UserRole {

    MOTORISTA("motorista"),
    FUNCIONARIO("funcionario"),
    ADMIN("admin"),
    ENTREGADOR("entregador"),
    SAC("sac"),
    USER("user");

    private final String role;

    /**
     * Construtor para a enumeração UserRole.
     * 
     * @param role o nome do papel de usuário
     */
    UserRole(String role) {
        this.role = role;
    }

    /**
     * Retorna o nome do papel de usuário.
     * 
     * @return o nome do papel
     */
    public String getRole() {
        return role;
    }
}

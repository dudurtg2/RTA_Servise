package com.example.empresa.services;

import com.example.empresa.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Interface para o serviço responsável pela recuperação de informações do usuário.
 * Extende o JPA Repository para facilitar operações de persistência com o tipo `Users`.
 * 
 * Este serviço é utilizado pelo Spring Security para buscar detalhes do usuário 
 * a partir do nome de login.
 */
public interface GetUserService extends JpaRepository<Users, String> {
    
    /**
     * Recupera os detalhes do usuário com base no nome de login fornecido.
     * Este método retorna um objeto {@link UserDetails} contendo informações do usuário 
     * necessárias para autenticação no sistema.
     * 
     * @param login o nome de login do usuário a ser buscado.
     * @return um objeto {@link UserDetails} com informações do usuário.
     */
    UserDetails findByLogin(String login);
}

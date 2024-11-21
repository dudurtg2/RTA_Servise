package com.example.empresa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Serviço de autorização responsável por carregar os detalhes do usuário 
 * a partir do nome de usuário (login). Implementa a interface {@link UserDetailsService},
 * fornecendo a lógica necessária para buscar as informações do usuário.
 * 
 * Este serviço é utilizado pelo Spring Security para autenticação de usuários.
 */
@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    private GetUserService service;

    /**
     * Carrega os detalhes do usuário a partir do nome de usuário fornecido.
     * Este método é chamado durante o processo de autenticação para recuperar as 
     * informações do usuário armazenadas no sistema.
     * 
     * @param username o nome de usuário (login) utilizado para buscar o usuário.
     * @return um objeto {@link UserDetails} contendo as informações do usuário.
     * @throws UsernameNotFoundException caso o usuário não seja encontrado.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return service.findByLogin(username);
    }

}

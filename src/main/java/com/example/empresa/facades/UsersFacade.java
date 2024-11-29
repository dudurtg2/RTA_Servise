package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.UsersApplication;
import com.example.empresa.entities.Users;
import com.example.empresa.security.DTO.RegisterDTO;

/**
 * Fachada responsável pela mediação das operações de persistência e lógica de negócios
 * entre a camada de controle e a camada de aplicação para a entidade {@link Users}.
 * Fornece métodos para realizar operações de CRUD (Create, Read, Update, Delete) para a entidade {@link Users}.
 */
@Component
public class UsersFacade {

    private UsersApplication usersApplication;

    /**
     * Construtor para injeção de dependência da {@link UsersApplication}.
     *
     * @param usersApplication a aplicação que gerencia a lógica de negócios para a entidade {@link Users}.
     */
    public UsersFacade(UsersApplication usersApplication) {
        this.usersApplication = usersApplication;
    }

    /**
     * Retorna a lista de todos os usuários armazenados no sistema.
     *
     * @return uma lista de objetos {@link Users}.
     */
    public List<Users> findAll() {
        return this.usersApplication.findAll();
    }

    /**
     * Retorna um objeto {@link Users} com base no seu identificador único.
     *
     * @param id o identificador único do usuário a ser encontrado.
     * @return o objeto {@link Users} correspondente ao identificador fornecido ou {@code null} se não encontrado.
     */
    public Users findById(long id) {
        return this.usersApplication.findById(id);
    }

    /**
     * Salva um novo objeto {@link Users} no sistema.
     *
     * @param users o objeto {@link Users} a ser salvo.
     * @return o objeto {@link Users} que foi salvo.
     */
    public Users save(RegisterDTO users) {
        return this.usersApplication.save(users);
    }

    /**
     * Atualiza um objeto {@link Users} existente no sistema.
     *
     * @param id o identificador único do usuário a ser atualizado.
     * @param users o objeto {@link Users} com os novos dados a serem atualizados.
     * @return o objeto {@link Users} atualizado ou {@code null} caso o identificador não seja encontrado.
     */
    public Users update(long id, Users users) {
        
        Users usersInDb = this.usersApplication.findById(id);
        if (usersInDb == null) {
            return null;
        }

        return this.usersApplication.update(id, users);
    }

    /**
     * Exclui um objeto {@link Users} com base no seu identificador único.
     *
     * @param id o identificador único do usuário a ser excluído.
     */
    public void deleteById(long id) {
        this.usersApplication.deleteById(id);
    }

    public <T> T findByEmail(String email) {
        return this.usersApplication.findByEmail(email);
    }

}

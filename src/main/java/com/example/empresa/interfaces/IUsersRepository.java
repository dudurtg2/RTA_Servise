package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.empresa.entities.Users;

/**
 * Interface de repositório para a entidade {@link Users}.
 * Define os métodos básicos para operações CRUD (Create, Read, Update, Delete) no repositório.
 * O repositório interage com a camada de persistência de dados para a entidade {@link Users}.
 */
@Repository
public interface IUsersRepository {

    /**
     * Recupera todas as instâncias da entidade {@link Users}.
     * 
     * @return Uma lista contendo todas as instâncias de {@link Users}.
     */
    List<Users> findAll();

    /**
     * Recupera uma instância de {@link Users} com base no identificador único.
     * 
     * @param id O identificador único da instância de {@link Users}.
     * @return A instância de {@link Users} correspondente ao id, ou null se não encontrada.
     */
    Users findById(int id);

    /**
     * Salva uma nova instância de {@link Users} no repositório.
     * 
     * @param users A instância de {@link Users} a ser salva.
     * @return A instância de {@link Users} salva.
     */
    Users save(Users users);

    /**
     * Atualiza uma instância existente de {@link Users}.
     * 
     * @param id O identificador único da instância a ser atualizada.
     * @param users A nova instância de {@link Users} com as atualizações.
     * @return A instância de {@link Users} atualizada, ou null se não encontrada.
     */
    Users update(int id, Users users);

    /**
     * Exclui a instância de {@link Users} com base no identificador único.
     * 
     * @param id O identificador único da instância a ser excluída.
     */
    void deleteById(int id);
}

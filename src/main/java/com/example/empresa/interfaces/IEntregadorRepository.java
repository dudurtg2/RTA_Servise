package com.example.empresa.interfaces;

import com.example.empresa.entities.Entregador;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface de repositório para a entidade {@link Entregador}.
 * Define os métodos básicos para operações CRUD (Create, Read, Update, Delete) no repositório.
 * O repositório interage com a camada de persistência de dados.
 */
@Repository
public interface IEntregadorRepository {

    /**
     * Recupera todas as instâncias da entidade {@link Entregador}.
     * 
     * @return Uma lista contendo todas as instâncias de {@link Entregador}.
     */
    List<Entregador> findAll();

    /**
     * Recupera uma instância de {@link Entregador} com base no identificador único.
     * 
     * @param id O identificador único da instância de {@link Entregador}.
     * @return A instância de {@link Entregador} correspondente ao id, ou null se não encontrado.
     */
    Entregador findById(long id);

    /**
     * Salva uma nova instância de {@link Entregador} no repositório.
     * 
     * @param entregador A instância de {@link Entregador} a ser salva.
     * @return A instância de {@link Entregador} salva.
     */
    Entregador save(Entregador entregador);

    /**
     * Atualiza uma instância existente de {@link Entregador}.
     * 
     * @param id O identificador único da instância a ser atualizada.
     * @param entregador A nova instância de {@link Entregador} com as atualizações.
     * @return A instância de {@link Entregador} atualizada, ou null se não encontrada.
     */
    Entregador update(long id, Entregador entregador);

    /**
     * Exclui a instância de {@link Entregador} com base no identificador único.
     * 
     * @param id O identificador único da instância a ser excluída.
     */
    void deleteById(long id);

    /**
     * Recupera uma instância de {@link Entregador} com base no email.
     *
     * @param email O email da instância de {@link Entregador}.
     * @return A instância de {@link Entregador} correspondente ao email, ou null se não encontrado.
     */
    Entregador findByEmail(String email);
}


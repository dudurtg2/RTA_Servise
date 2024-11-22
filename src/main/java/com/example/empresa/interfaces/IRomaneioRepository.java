package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.empresa.entities.Romaneio;

/**
 * Interface de repositório para a entidade {@link Romaneio}.
 * Define os métodos básicos para operações CRUD (Create, Read, Update, Delete) no repositório.
 * O repositório interage com a camada de persistência de dados para a entidade {@link Romaneio}.
 */
@Repository
public interface IRomaneioRepository {

    /**
     * Recupera todas as instâncias da entidade {@link Romaneio}.
     * 
     * @return Uma lista contendo todas as instâncias de {@link Romaneio}.
     */
    List<Romaneio> findAll();

    /**
     * Recupera uma instância de {@link Romaneio} com base no identificador único.
     * 
     * @param id O identificador único da instância de {@link Romaneio}.
     * @return A instância de {@link Romaneio} correspondente ao id, ou null se não encontrada.
     */
    Romaneio findById(int id);

    /**
     * Salva uma nova instância de {@link Romaneio} no repositório.
     * 
     * @param romaneio A instância de {@link Romaneio} a ser salva.
     * @return A instância de {@link Romaneio} salva.
     */
    Romaneio save(Romaneio romaneio);

    /**
     * Atualiza uma instância existente de {@link Romaneio}.
     * 
     * @param id O identificador único da instância a ser atualizada.
     * @param romaneio A nova instância de {@link Romaneio} com as atualizações.
     * @return A instância de {@link Romaneio} atualizada, ou null se não encontrada.
     */
    Romaneio update(int id, Romaneio romaneio);

    /**
     * Exclui a instância de {@link Romaneio} com base no identificador único.
     * 
     * @param id O identificador único da instância a ser excluída.
     */
    void deleteById(int id);
}

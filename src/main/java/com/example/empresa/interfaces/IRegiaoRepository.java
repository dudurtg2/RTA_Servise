package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.empresa.entities.Regiao;

/**
 * Interface de repositório para a entidade {@link Regiao}.
 * Define os métodos básicos para operações CRUD (Create, Read, Update, Delete) no repositório.
 * O repositório interage com a camada de persistência de dados para a entidade {@link Regiao}.
 */
@Repository
public interface IRegiaoRepository {

    /**
     * Recupera todas as instâncias da entidade {@link Regiao}.
     * 
     * @return Uma lista contendo todas as instâncias de {@link Regiao}.
     */
    List<Regiao> findAll();

    /**
     * Recupera uma instância de {@link Regiao} com base no identificador único.
     * 
     * @param id O identificador único da instância de {@link Regiao}.
     * @return A instância de {@link Regiao} correspondente ao id, ou null se não encontrada.
     */
    Regiao findById(int id);

    /**
     * Salva uma nova instância de {@link Regiao} no repositório.
     * 
     * @param regiao A instância de {@link Regiao} a ser salva.
     * @return A instância de {@link Regiao} salva.
     */
    Regiao save(Regiao regiao);

    /**
     * Atualiza uma instância existente de {@link Regiao}.
     * 
     * @param id O identificador único da instância a ser atualizada.
     * @param regiao A nova instância de {@link Regiao} com as atualizações.
     * @return A instância de {@link Regiao} atualizada, ou null se não encontrada.
     */
    Regiao update(int id, Regiao regiao);

    /**
     * Exclui a instância de {@link Regiao} com base no identificador único.
     * 
     * @param id O identificador único da instância a ser excluída.
     */
    void deleteById(int id);
}

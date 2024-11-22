package com.example.empresa.interfaces;

import com.example.empresa.entities.Codigo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface de repositório para a entidade {@link Codigo}.
 * Define os métodos básicos para operações CRUD (Create, Read, Update, Delete) no repositório.
 * O repositório interage com a camada de persistência de dados.
 */
@Repository
public interface ICodigoRepository {

    /**
     * Recupera todas as instâncias da entidade {@link Codigo}.
     * 
     * @return Uma lista contendo todas as instâncias de {@link Codigo}.
     */
    List<Codigo> findAll();

    /**
     * Recupera uma instância de {@link Codigo} com base no identificador único.
     * 
     * @param id O identificador único da instância de {@link Codigo}.
     * @return A instância de {@link Codigo} correspondente ao id, ou null se não encontrado.
     */
    Codigo findById(int id);

    /**
     * Salva uma nova instância de {@link Codigo} no repositório.
     * 
     * @param codigo A instância de {@link Codigo} a ser salva.
     * @return A instância de {@link Codigo} salva.
     */
    Codigo save(Codigo codigo);

    /**
     * Atualiza uma instância existente de {@link Codigo}.
     * 
     * @param id O identificador único da instância a ser atualizada.
     * @param codigo A nova instância de {@link Codigo} com as atualizações.
     * @return A instância de {@link Codigo} atualizada, ou null se não encontrada.
     */
    Codigo update(int id, Codigo codigo);

    /**
     * Exclui a instância de {@link Codigo} com base no identificador único.
     * 
     * @param id O identificador único da instância a ser excluída.
     */
    void deleteById(int id);
}

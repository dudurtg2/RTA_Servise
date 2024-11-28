package com.example.empresa.interfaces;

import com.example.empresa.entities.Cidade;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface de repositório para a entidade {@link Cidade}.
 * Define os métodos básicos para operações CRUD (Create, Read, Update, Delete) no repositório.
 * O repositório interage com a camada de persistência de dados.
 */
@Repository
public interface ICidadeRepository {

    /**
     * Recupera todas as instâncias da entidade {@link Cidade}.
     * 
     * @return Uma lista contendo todas as instâncias de {@link Cidade}.
     */
    List<Cidade> findAll();

    /**
     * Recupera uma instância de {@link Cidade} com base no identificador único.
     * 
     * @param id O identificador único da instância de {@link Cidade}.
     * @return A instância de {@link Cidade} correspondente ao id, ou null se não encontrado.
     */
    Cidade findById(long id);

    /**
     * Salva uma nova instância de {@link Cidade} no repositório.
     * 
     * @param cidade A instância de {@link Cidade} a ser salva.
     * @return A instância de {@link Cidade} salva.
     */
    Cidade save(Cidade cidade);

    /**
     * Atualiza uma instância existente de {@link Cidade}.
     * 
     * @param id O identificador único da instância a ser atualizada.
     * @param cidade A nova instância de {@link Cidade} com as atualizações.
     * @return A instância de {@link Cidade} atualizada, ou null se não encontrada.
     */
    Cidade update(long id, Cidade cidade);

    /**
     * Exclui a instância de {@link Cidade} com base no identificador único.
     * 
     * @param id O identificador único da instância a ser excluída.
     */
    void deleteById(long id);
}


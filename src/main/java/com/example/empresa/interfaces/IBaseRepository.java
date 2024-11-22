package com.example.empresa.interfaces;

import com.example.empresa.entities.Base;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface de repositório para a entidade {@link Base}.
 * Define os métodos básicos para operações CRUD (Create, Read, Update, Delete) no repositório.
 * O repositório interage com a camada de persistência de dados.
 */
@Repository
public interface IBaseRepository {

    /**
     * Recupera todas as instâncias da entidade {@link Base}.
     * 
     * @return Uma lista contendo todas as instâncias de {@link Base}.
     */
    List<Base> findAll();

    /**
     * Recupera uma instância de {@link Base} com base no identificador único.
     * 
     * @param id O identificador único da instância de {@link Base}.
     * @return A instância de {@link Base} correspondente ao id, ou null se não encontrado.
     */
    Base findById(int id);

    /**
     * Salva uma nova instância de {@link Base} no repositório.
     * 
     * @param base A instância de {@link Base} a ser salva.
     * @return A instância de {@link Base} salva.
     */
    Base save(Base base);

    /**
     * Atualiza uma instância existente de {@link Base}.
     * 
     * @param id O identificador único da instância a ser atualizada.
     * @param base A nova instância de {@link Base} com as atualizações.
     * @return A instância de {@link Base} atualizada, ou null se não encontrado.
     */
    Base update(int id, Base base);

    /**
     * Exclui a instância de {@link Base} com base no identificador único.
     * 
     * @param id O identificador único da instância a ser excluída.
     */
    void deleteById(int id);
}

   

package com.example.empresa.interfaces;

import com.example.empresa.entities.Empresa;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface de repositório para a entidade {@link Empresa}.
 * Define os métodos básicos para operações CRUD (Create, Read, Update, Delete) no repositório.
 * O repositório interage com a camada de persistência de dados.
 */
@Repository
public interface IEmpresaRepository {

    /**
     * Recupera todas as instâncias da entidade {@link Empresa}.
     * 
     * @return Uma lista contendo todas as instâncias de {@link Empresa}.
     */
    List<Empresa> findAll();

    /**
     * Recupera uma instância de {@link Empresa} com base no identificador único.
     * 
     * @param id O identificador único da instância de {@link Empresa}.
     * @return A instância de {@link Empresa} correspondente ao id, ou null se não encontrado.
     */
    Empresa findById(long id);

    /**
     * Salva uma nova instância de {@link Empresa} no repositório.
     * 
     * @param empresa A instância de {@link Empresa} a ser salva.
     * @return A instância de {@link Empresa} salva.
     */
    Empresa save(Empresa empresa);

    /**
     * Atualiza uma instância existente de {@link Empresa}.
     * 
     * @param id O identificador único da instância a ser atualizada.
     * @param empresa A nova instância de {@link Empresa} com as atualizações.
     * @return A instância de {@link Empresa} atualizada, ou null se não encontrada.
     */
    Empresa update(long id, Empresa empresa);

    /**
     * Exclui a instância de {@link Empresa} com base no identificador único.
     * 
     * @param id O identificador único da instância a ser excluída.
     */
    void deleteById(long id);
}

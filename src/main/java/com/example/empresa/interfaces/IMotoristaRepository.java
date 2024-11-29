package com.example.empresa.interfaces;

import com.example.empresa.entities.Motorista;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interface de repositório para a entidade {@link Motorista}.
 * Define os métodos básicos para operações CRUD (Create, Read, Update, Delete) no repositório.
 * O repositório interage com a camada de persistência de dados.
 */
@Repository
public interface IMotoristaRepository {

    /**
     * Recupera todas as instâncias da entidade {@link Motorista}.
     * 
     * @return Uma lista contendo todas as instâncias de {@link Motorista}.
     */
    List<Motorista> findAll();

    /**
     * Recupera uma instância de {@link Motorista} com base no identificador único.
     * 
     * @param id O identificador único da instância de {@link Motorista}.
     * @return A instância de {@link Motorista} correspondente ao id, ou null se não encontrado.
     */
    Motorista findById(long id);

    /**
     * Salva uma nova instância de {@link Motorista} no repositório.
     * 
     * @param motorista A instância de {@link Motorista} a ser salva.
     * @return A instância de {@link Motorista} salva.
     */
    Motorista save(Motorista motorista);

    /**
     * Atualiza uma instância existente de {@link Motorista}.
     * 
     * @param id O identificador único da instância a ser atualizada.
     * @param motorista A nova instância de {@link Motorista} com as atualizações.
     * @return A instância de {@link Motorista} atualizada, ou null se não encontrada.
     */
    Motorista update(long id, Motorista motorista);

    /**
     * Exclui a instância de {@link Motorista} com base no identificador único.
     * 
     * @param id O identificador único da instância a ser excluída.
     */
    void deleteById(long id);

    /**
     * Recupera uma instância de {@link Motorista} com base no email.
     *
     * @param email O email da instância de {@link Motorista}.
     * @return A instância de {@link Motorista} correspondente ao email, ou null se não encontrado.
     */
    Motorista findByEmail(String email);
}

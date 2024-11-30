package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.empresa.entities.Funcionario;

/**
 * Interface de repositório para a entidade {@link Funcionario}.
 * Define os métodos básicos para operações CRUD (Create, Read, Update, Delete) no repositório.
 * O repositório interage com a camada de persistência de dados.
 */
@Repository
public interface IFuncionarioRepository {

    /**
     * Recupera todas as instâncias da entidade {@link Funcionario}.
     * 
     * @return Uma lista contendo todas as instâncias de {@link Funcionario}.
     */
    List<Funcionario> findAll();

    /**
     * Recupera uma instância de {@link Funcionario} com base no identificador único.
     * 
     * @param id O identificador único da instância de {@link Funcionario}.
     * @return A instância de {@link Funcionario} correspondente ao id, ou null se não encontrado.
     */
    Funcionario findById(long id);

    /**
     * Recupera uma instância de {@link Funcionario} com base no endereço de email.
     * 
     * @param email O endereço de email do funcionário.
     * @return A instância de {@link Funcionario} correspondente ao email, ou null se não encontrado.
     */
    Funcionario findByEmail(String email);

    /**
     * Salva uma nova instância de {@link Funcionario} no repositório.
     * 
     * @param funcionario A instância de {@link Funcionario} a ser salva.
     * @return A instância de {@link Funcionario} salva.
     */
    Funcionario save(Funcionario funcionario);

    /**
     * Atualiza uma instância existente de {@link Funcionario}.
     * 
     * @param id O identificador único da instância a ser atualizada.
     * @param funcionario A nova instância de {@link Funcionario} com as atualizações.
     * @return A instância de {@link Funcionario} atualizada, ou null se não encontrada.
     */
    Funcionario update(long id, Funcionario funcionario);

    /**
     * Exclui a instância de {@link Funcionario} com base no identificador único.
     * 
     * @param id O identificador único da instância a ser excluída.
     */
    void deleteById(long id);

    /**
     * Recupera uma instância de {@link Funcionario} com base no CPF.
     * 
     * @param cpf O CPF do funcionário.
     * @return A instância de {@link Funcionario} correspondente ao CPF, ou null se não encontrado.
     */
    Funcionario findByCpf(String cpf);
    
}

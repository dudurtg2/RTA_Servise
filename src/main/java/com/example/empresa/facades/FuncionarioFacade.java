package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.FuncionarioApplication;
import com.example.empresa.entities.Funcionario;

/**
 * Fachada responsável pela lógica de negócios e pela mediação das operações de persistência
 * entre a camada de controle e a camada de aplicação para a entidade {@link Funcionario}.
 * Através dessa fachada, são realizadas as operações de CRUD (Create, Read, Update, Delete)
 * para a entidade {@link Funcionario}.
 */
@Component
public class FuncionarioFacade {

    private final FuncionarioApplication funcionarioApplication;

    /**
     * Construtor para injeção de dependência da {@link FuncionarioApplication}.
     *
     * @param funcionarioApplication a aplicação que gerencia a lógica de negócios para a entidade {@link Funcionario}.
     */
    public FuncionarioFacade(FuncionarioApplication funcionarioApplication) {
        this.funcionarioApplication = funcionarioApplication;
    }

    /**
     * Retorna a lista de todos os funcionários armazenados no sistema.
     *
     * @return uma lista de objetos {@link Funcionario}.
     */
    public List<Funcionario> findAll() {
        return this.funcionarioApplication.findAll();
    }

    /**
     * Retorna um objeto {@link Funcionario} com base no seu identificador único.
     *
     * @param id o identificador único do funcionário a ser encontrado.
     * @return o objeto {@link Funcionario} correspondente ao identificador fornecido ou {@code null} se não encontrado.
     */
    public Funcionario findById(int id) {
        return this.funcionarioApplication.findById(id);
    }

    /**
     * Salva um novo objeto {@link Funcionario} no sistema.
     *
     * @param funcionario o objeto {@link Funcionario} a ser salvo.
     * @return o objeto {@link Funcionario} que foi salvo.
     */
    public Funcionario save(Funcionario funcionario) {
        return this.funcionarioApplication.save(funcionario);
    }

    /**
     * Atualiza um objeto {@link Funcionario} existente no sistema.
     *
     * @param id o identificador único do funcionário a ser atualizado.
     * @param funcionario o objeto {@link Funcionario} com os novos dados a serem atualizados.
     * @return o objeto {@link Funcionario} atualizado ou {@code null} caso o identificador não seja encontrado.
     */
    public Funcionario update(int id, Funcionario funcionario) {
        return this.funcionarioApplication.update(id, funcionario);
    }

    /**
     * Exclui um objeto {@link Funcionario} com base no seu identificador único.
     *
     * @param id o identificador único do funcionário a ser excluído.
     */
    public void deleteById(int id) {
        this.funcionarioApplication.deleteById(id);
    }
}

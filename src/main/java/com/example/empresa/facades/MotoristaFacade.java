package com.example.empresa.facades;

import com.example.empresa.applications.MotoristaApplication;
import com.example.empresa.entities.Motorista;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Fachada responsável pela mediação das operações de persistência e lógica de negócios
 * entre a camada de controle e a camada de aplicação para a entidade {@link Motorista}.
 * Fornece métodos para realizar operações de CRUD (Create, Read, Update, Delete) para a entidade {@link Motorista}.
 */
@Component
public class MotoristaFacade {

    private MotoristaApplication motoristaApplication;

    /**
     * Construtor para injeção de dependência da {@link MotoristaApplication}.
     *
     * @param motoristaApplication a aplicação que gerencia a lógica de negócios para a entidade {@link Motorista}.
     */
    public MotoristaFacade(MotoristaApplication motoristaApplication) {
        this.motoristaApplication = motoristaApplication;
    }

    /**
     * Retorna a lista de todos os motoristas armazenados no sistema.
     *
     * @return uma lista de objetos {@link Motorista}.
     */
    public List<Motorista> findAll() {
        return this.motoristaApplication.findAll();
    }

    /**
     * Retorna um objeto {@link Motorista} com base no seu identificador único.
     *
     * @param id o identificador único do motorista a ser encontrado.
     * @return o objeto {@link Motorista} correspondente ao identificador fornecido ou {@code null} se não encontrado.
     */
    public Motorista findById(long id) {
        return this.motoristaApplication.findById(id);
    }

    /**
     * Salva um novo objeto {@link Motorista} no sistema.
     *
     * @param motorista o objeto {@link Motorista} a ser salvo.
     * @return o objeto {@link Motorista} que foi salvo.
     */
    public Motorista save(Motorista motorista) {
        return this.motoristaApplication.save(motorista);
    }

    /**
     * Atualiza um objeto {@link Motorista} existente no sistema.
     *
     * @param id o identificador único do motorista a ser atualizado.
     * @param motorista o objeto {@link Motorista} com os novos dados a serem atualizados.
     * @return o objeto {@link Motorista} atualizado ou {@code null} caso o identificador não seja encontrado.
     */
    public Motorista update(long id, Motorista motorista) {
        return this.motoristaApplication.update(id, motorista);
    }

    /**
     * Exclui um objeto {@link Motorista} com base no seu identificador único.
     *
     * @param id o identificador único do motorista a ser excluído.
     */
    public void deleteById(long id) {
        this.motoristaApplication.deleteById(id);
    }
}

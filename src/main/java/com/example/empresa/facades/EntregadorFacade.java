package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.EntregadorApplication;
import com.example.empresa.entities.Entregador;

/**
 * Fachada responsável pela lógica de negócios e pela mediação das operações de persistência
 * entre a camada de controle e a camada de aplicação para a entidade {@link Entregador}.
 * Através dessa fachada, são realizadas as operações de CRUD (Create, Read, Update, Delete)
 * para a entidade {@link Entregador}.
 */
@Component
public class EntregadorFacade {

    private final EntregadorApplication entregadorApplication;

    /**
     * Construtor para injeção de dependência da {@link EntregadorApplication}.
     *
     * @param entregadorApplication a aplicação que gerencia a lógica de negócios para a entidade {@link Entregador}.
     */
    public EntregadorFacade(EntregadorApplication entregadorApplication) {
        this.entregadorApplication = entregadorApplication;
    }

    /**
     * Retorna a lista de todos os entregadores armazenados no sistema.
     *
     * @return uma lista de objetos {@link Entregador}.
     */
    public List<Entregador> findAll() {
        return this.entregadorApplication.findAll();
    }

    /**
     * Retorna um objeto {@link Entregador} com base no seu identificador único.
     *
     * @param id o identificador único do entregador a ser encontrado.
     * @return o objeto {@link Entregador} correspondente ao identificador fornecido ou {@code null} se não encontrado.
     */
    public Entregador findById(int id) {
        return this.entregadorApplication.findById(id);
    }

    /**
     * Salva um novo objeto {@link Entregador} no sistema.
     *
     * @param entregador o objeto {@link Entregador} a ser salvo.
     * @return o objeto {@link Entregador} que foi salvo.
     */
    public Entregador save(Entregador entregador) {
        return this.entregadorApplication.save(entregador);
    }

    /**
     * Atualiza um objeto {@link Entregador} existente no sistema.
     *
     * @param id o identificador único do entregador a ser atualizado.
     * @param entregador o objeto {@link Entregador} com os novos dados a serem atualizados.
     * @return o objeto {@link Entregador} atualizado ou {@code null} caso o identificador não seja encontrado.
     */
    public Entregador update(int id, Entregador entregador) {
        return this.entregadorApplication.update(id, entregador);
    }

    /**
     * Exclui um objeto {@link Entregador} com base no seu identificador único.
     *
     * @param id o identificador único do entregador a ser excluído.
     */
    public void deleteById(int id) {
        this.entregadorApplication.deleteById(id);
    }
}

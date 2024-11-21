package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.CodigoApplication;
import com.example.empresa.entities.Codigo;

/**
 * Fachada responsável pela lógica de negócios e pela mediação das operações de persistência
 * entre a camada de controle e a camada de aplicação para a entidade {@link Codigo}.
 * Através dessa fachada, são realizadas as operações de CRUD (Create, Read, Update, Delete)
 * para a entidade {@link Codigo}.
 */
@Component
public class CodigoFacade {

    private final CodigoApplication codigoApplication;

    /**
     * Construtor para injeção de dependência da {@link CodigoApplication}.
     *
     * @param codigoApplication a aplicação que gerencia a lógica de negócios para a entidade {@link Codigo}.
     */
    public CodigoFacade(CodigoApplication codigoApplication) {
        this.codigoApplication = codigoApplication;
    }

    /**
     * Retorna a lista de todos os códigos armazenados no sistema.
     *
     * @return uma lista de objetos {@link Codigo}.
     */
    public List<Codigo> findAll() {
        return this.codigoApplication.findAll();
    }

    /**
     * Retorna um objeto {@link Codigo} com base no seu identificador único.
     *
     * @param id o identificador único do código a ser encontrado.
     * @return o objeto {@link Codigo} correspondente ao identificador fornecido ou {@code null} se não encontrado.
     */
    public Codigo findById(int id) {
        return this.codigoApplication.findById(id);
    }

    /**
     * Salva um novo objeto {@link Codigo} no sistema.
     *
     * @param codigo o objeto {@link Codigo} a ser salvo.
     * @return o objeto {@link Codigo} que foi salvo.
     */
    public Codigo save(Codigo codigo) {
        return this.codigoApplication.save(codigo);
    }

    /**
     * Atualiza um objeto {@link Codigo} existente no sistema.
     *
     * @param id o identificador único do código a ser atualizado.
     * @param codigo o objeto {@link Codigo} com os novos dados a serem atualizados.
     * @return o objeto {@link Codigo} atualizado ou {@code null} caso o identificador não seja encontrado.
     */
    public Codigo update(int id, Codigo codigo) {
        return this.codigoApplication.update(id, codigo);
    }

    /**
     * Exclui um objeto {@link Codigo} com base no seu identificador único.
     *
     * @param id o identificador único do código a ser excluído.
     */
    public void deleteById(int id) {
        this.codigoApplication.deleteById(id);
    }
}

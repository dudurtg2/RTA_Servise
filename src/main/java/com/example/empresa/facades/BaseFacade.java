package com.example.empresa.facades;

import com.example.empresa.applications.BaseApplication;
import com.example.empresa.entities.Base;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Fachada responsável pela lógica de negócios e pela mediação das operações de persistência
 * entre a camada de controle e a camada de aplicação para a entidade {@link Base}.
 * Através dessa fachada, são realizadas as operações de CRUD (Create, Read, Update, Delete) 
 * para a entidade {@link Base}.
 */
@Component
public class BaseFacade {

    private final BaseApplication baseApplication;

    /**
     * Construtor para injeção de dependência da {@link BaseApplication}.
     *
     * @param baseApplication a aplicação que gerencia a lógica de negócios para a entidade {@link Base}.
     */
    public BaseFacade(BaseApplication baseApplication) {
        this.baseApplication = baseApplication;
    }

    /**
     * Retorna a lista de todos os objetos {@link Base} armazenados no sistema.
     *
     * @return uma lista de objetos {@link Base}.
     */
    public List<Base> findAll() {
        return this.baseApplication.findAll();
    }

    /**
     * Retorna um objeto {@link Base} com base no seu identificador único.
     *
     * @param id o identificador único do objeto {@link Base} a ser encontrado.
     * @return o objeto {@link Base} correspondente ao identificador fornecido ou {@code null} se não encontrado.
     */
    public Base findById(long id) {
        return this.baseApplication.findById(id);
    }

    /**
     * Salva um novo objeto {@link Base} no sistema.
     *
     * @param base o objeto {@link Base} a ser salvo.
     * @return o objeto {@link Base} que foi salvo.
     */
    public Base save(Base base) {
        return this.baseApplication.save(base);
    }

    /**
     * Atualiza um objeto {@link Base} existente no sistema.
     *
     * @param id o identificador único do objeto {@link Base} a ser atualizado.
     * @param base o objeto {@link Base} com os novos dados a serem atualizados.
     * @return o objeto {@link Base} atualizado ou {@code null} caso o identificador não seja encontrado.
     */
    public Base update(long id, Base base) {
        return this.baseApplication.update(id, base);
    }

    /**
     * Exclui um objeto {@link Base} com base no seu identificador único.
     *
     * @param id o identificador único do objeto {@link Base} a ser excluído.
     */
    public void deleteById(long id) {
        this.baseApplication.deleteById(id);
    }
}

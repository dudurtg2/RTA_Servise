package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.RegiaoApplication;
import com.example.empresa.entities.Regiao;

/**
 * Fachada responsável pela mediação das operações de persistência e lógica de negócios
 * entre a camada de controle e a camada de aplicação para a entidade {@link Regiao}.
 * Fornece métodos para realizar operações de CRUD (Create, Read, Update, Delete) para a entidade {@link Regiao}.
 */
@Component
public class RegiaoFacade {

    private final RegiaoApplication regiaoApplication;

    /**
     * Construtor para injeção de dependência da {@link RegiaoApplication}.
     *
     * @param regiaoApplication a aplicação que gerencia a lógica de negócios para a entidade {@link Regiao}.
     */
    public RegiaoFacade(RegiaoApplication regiaoApplication) {
        this.regiaoApplication = regiaoApplication;
    }

    /**
     * Retorna a lista de todas as regiões armazenadas no sistema.
     *
     * @return uma lista de objetos {@link Regiao}.
     */
    public List<Regiao> findAll() {
        return this.regiaoApplication.findAll();
    }

    /**
     * Retorna um objeto {@link Regiao} com base no seu identificador único.
     *
     * @param id o identificador único da região a ser encontrada.
     * @return o objeto {@link Regiao} correspondente ao identificador fornecido ou {@code null} se não encontrado.
     */
    public Regiao findById(long id) {
        return this.regiaoApplication.findById(id);
    }

    /**
     * Salva um novo objeto {@link Regiao} no sistema.
     *
     * @param regiao o objeto {@link Regiao} a ser salvo.
     * @return o objeto {@link Regiao} que foi salvo.
     */
    public Regiao save(Regiao regiao) {
        return this.regiaoApplication.save(regiao);
    }

    /**
     * Atualiza um objeto {@link Regiao} existente no sistema.
     *
     * @param id o identificador único da região a ser atualizada.
     * @param regiao o objeto {@link Regiao} com os novos dados a serem atualizados.
     * @return o objeto {@link Regiao} atualizado ou {@code null} caso o identificador não seja encontrado.
     */
    public Regiao update(long id, Regiao regiao) {
        return this.regiaoApplication.update(id, regiao);
    }

    /**
     * Exclui um objeto {@link Regiao} com base no seu identificador único.
     *
     * @param id o identificador único da região a ser excluída.
     */
    public void deleteById(long id) {
        this.regiaoApplication.deleteById(id);
    }
}

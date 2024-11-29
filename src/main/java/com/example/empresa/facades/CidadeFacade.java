package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.CidadeApplication;
import com.example.empresa.entities.Cidade;

/**
 * Fachada responsável pela lógica de negócios e pela mediação das operações de persistência
 * entre a camada de controle e a camada de aplicação para a entidade {@link Cidade}.
 * Através dessa fachada, são realizadas as operações de CRUD (Create, Read, Update, Delete)
 * para a entidade {@link Cidade}.
 */
@Component
public class CidadeFacade {

    private CidadeApplication cidadeApplication;

    /**
     * Construtor para injeção de dependência da {@link CidadeApplication}.
     *
     * @param cidadeApplication a aplicação que gerencia a lógica de negócios para a entidade {@link Cidade}.
     */
    public CidadeFacade(CidadeApplication cidadeApplication) {
        this.cidadeApplication = cidadeApplication;
    }

    /**
     * Retorna a lista de todas as cidades armazenadas no sistema.
     *
     * @return uma lista de objetos {@link Cidade}.
     */
    public List<Cidade> findAll() {
        return this.cidadeApplication.findAll();
    }

    /**
     * Retorna um objeto {@link Cidade} com base no seu identificador único.
     *
     * @param id o identificador único da cidade a ser encontrada.
     * @return o objeto {@link Cidade} correspondente ao identificador fornecido ou {@code null} se não encontrado.
     */
    public Cidade findById(long id) {
        return this.cidadeApplication.findById(id);
    }

    /**
     * Salva um novo objeto {@link Cidade} no sistema.
     *
     * @param cidade o objeto {@link Cidade} a ser salvo.
     * @return o objeto {@link Cidade} que foi salvo.
     */
    public Cidade save(Cidade cidade) {
        return this.cidadeApplication.save(cidade);
    }

    /**
     * Atualiza um objeto {@link Cidade} existente no sistema.
     *
     * @param id o identificador único da cidade a ser atualizada.
     * @param cidade o objeto {@link Cidade} com os novos dados a serem atualizados.
     * @return o objeto {@link Cidade} atualizado ou {@code null} caso o identificador não seja encontrado.
     */
    public Cidade update(long id, Cidade cidade) {
        return this.cidadeApplication.update(id, cidade);
    }

    /**
     * Exclui um objeto {@link Cidade} com base no seu identificador único.
     *
     * @param id o identificador único da cidade a ser excluída.
     */
    public void deleteById(long id) {
        this.cidadeApplication.deleteById(id);
    }
}

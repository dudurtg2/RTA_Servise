package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.RomaneioApplication;
import com.example.empresa.entities.Romaneio;

/**
 * Fachada responsável pela mediação das operações de persistência e lógica de negócios
 * entre a camada de controle e a camada de aplicação para a entidade {@link Romaneio}.
 * Fornece métodos para realizar operações de CRUD (Create, Read, Update, Delete) para a entidade {@link Romaneio}.
 */
@Component
public class RomaneioFacade {

    private final RomaneioApplication romaneioApplication;

    /**
     * Construtor para injeção de dependência da {@link RomaneioApplication}.
     *
     * @param romaneioApplication a aplicação que gerencia a lógica de negócios para a entidade {@link Romaneio}.
     */
    public RomaneioFacade(RomaneioApplication romaneioApplication) {
        this.romaneioApplication = romaneioApplication;
    }

    /**
     * Retorna a lista de todos os romaneios armazenados no sistema.
     *
     * @return uma lista de objetos {@link Romaneio}.
     */
    public List<Romaneio> findAll() {
        return this.romaneioApplication.findAll();
    }

    /**
     * Retorna um objeto {@link Romaneio} com base no seu identificador único.
     *
     * @param id o identificador único do romaneio a ser encontrado.
     * @return o objeto {@link Romaneio} correspondente ao identificador fornecido ou {@code null} se não encontrado.
     */
    public Romaneio findById(int id) {
        return this.romaneioApplication.findById(id);
    }

    /**
     * Salva um novo objeto {@link Romaneio} no sistema.
     *
     * @param romaneio o objeto {@link Romaneio} a ser salvo.
     * @return o objeto {@link Romaneio} que foi salvo.
     */
    public Romaneio save(Romaneio romaneio) {
        return this.romaneioApplication.save(romaneio);
    }

    /**
     * Atualiza um objeto {@link Romaneio} existente no sistema.
     *
     * @param id o identificador único do romaneio a ser atualizado.
     * @param romaneio o objeto {@link Romaneio} com os novos dados a serem atualizados.
     * @return o objeto {@link Romaneio} atualizado ou {@code null} caso o identificador não seja encontrado.
     */
    public Romaneio update(int id, Romaneio romaneio) {
        return this.romaneioApplication.update(id, romaneio);
    }

    /**
     * Exclui um objeto {@link Romaneio} com base no seu identificador único.
     *
     * @param id o identificador único do romaneio a ser excluído.
     */
    public void deleteById(int id) {
        this.romaneioApplication.deleteById(id);
    }

    public int getCount(String status) {
        return this.romaneioApplication.getCount(status);
    }
}

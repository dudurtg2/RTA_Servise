package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.RomaneioApplication;
import com.example.empresa.controllers.records.RomaneioRecord;
import com.example.empresa.controllers.records.RomaneioUpdateRecord;
import com.example.empresa.entities.Romaneio;

/**
 * Fachada responsável pela mediação das operações de persistência e lógica de negócios
 * entre a camada de controle e a camada de aplicação para a entidade {@link Romaneio}.
 * Fornece métodos para realizar operações de CRUD (Create, Read, Update, Delete) para a entidade {@link Romaneio}.
 */
@Component
public class RomaneioFacade {

    private RomaneioApplication romaneioApplication;

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
    public Romaneio findById(long id) {
        return this.romaneioApplication.findById(id);
    }

    /**
     * Salva um novo objeto {@link Romaneio} no sistema.
     *
     * @param romaneio o objeto {@link Romaneio} a ser salvo.
     * @return o objeto {@link Romaneio} que foi salvo.
     */
    public Romaneio save(RomaneioRecord romaneio) {
        return this.romaneioApplication.save(romaneio);
    }

    /**
     * Atualiza um objeto {@link Romaneio} existente no sistema.
     *
     * @param id o identificador único do romaneio a ser atualizado.
     * @param romaneio o objeto {@link Romaneio} com os novos dados a serem atualizados.
     * @return o objeto {@link Romaneio} atualizado ou {@code null} caso o identificador não seja encontrado.
     */
    public Romaneio update(long id, RomaneioUpdateRecord romaneio) {
        return this.romaneioApplication.update(id, romaneio);
    }

    /**
     * Exclui um objeto {@link Romaneio} com base no seu identificador único.
     *
     * @param id o identificador único do romaneio a ser excluído.
     */
    public void deleteById(long id) {
        this.romaneioApplication.deleteById(id);
    }

    /**
     * Obtém o número de registros de romaneios com base em um status específico.
     *
     * @param status o status utilizado como critério de filtragem (ex.: "retirado", "aguardando", "finalizado").
     * @return o número de registros que correspondem ao status fornecido.
     */
    public int getCountForStatus(String status) {
        return this.romaneioApplication.getCountForStatus(status);
    }

    /**
     * Retorna uma lista de objetos {@link Romaneio} com base no status fornecido.
     *
     * @param sts o status utilizado como critério de filtragem.
     * @return uma lista de objetos {@link Romaneio} que correspondem ao status especificado.
     */
    public List<Romaneio> findByStatus(String sts) {
        return this.romaneioApplication.findByStatus(sts);
    }
    /**
     * Retorna uma lista de objetos {@link Romaneio} que cont m um motorista com o
     * identificador nico especificado.
     *
     * @param motorista o identificador do motorista utilizado como crit rio de
     *                   filtragem.
     * @return uma lista de objetos {@link Romaneio} que correspondem ao motorista
     *         especificado.
     */
    public List<Romaneio> findByMotorista(Long motorista) {
        return this.romaneioApplication.findByMotorista(motorista);
    }
    /**
     * Retorna uma lista de objetos {@link Romaneio} que cont m um entregador com o
     * identificador único especificado.
     *
     * @param entregador o identificador do entregador utilizado como crit rio de
     *                   filtragem.
     * @return uma lista contendo todas as inst ncia de {@link Romaneio} que
     *         cont m o entregador especificado.
     */

    public List<Romaneio> findByEntregador(Long entregador) {
        return this.romaneioApplication.findByEntregador(entregador);
    }
}

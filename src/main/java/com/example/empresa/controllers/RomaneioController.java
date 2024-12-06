package com.example.empresa.controllers;

import com.example.empresa.controllers.records.ResponceRecord;
import com.example.empresa.controllers.records.RomaneioRecord;
import com.example.empresa.controllers.records.RomaneioUpdateRecord;
import com.example.empresa.entities.Romaneio;
import com.example.empresa.facades.RomaneioFacade;
import com.example.empresa.services.CustomExceptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * Controlador REST para gerenciar operações relacionadas à entidade
 * {@link Romaneio}.
 * Permite realizar operações de CRUD (Create, Read, Update, Delete) sobre os
 * romaneios.
 */
@RestController
@RequestScope
@RequestMapping("/api/romaneios")
public class RomaneioController {

    private RomaneioFacade romaneioFacade;

    /**
     * Construtor para injeção de dependência do {@link RomaneioFacade}.
     *
     * @param romaneioFacade a fachada que gerencia a lógica de negócios para a
     *                       entidade {@link Romaneio}.
     */
    @Autowired
    public RomaneioController(RomaneioFacade romaneioFacade) {
        this.romaneioFacade = romaneioFacade;
    }

    /**
     * Retorna a lista de todos os romaneios.
     *
     * @return uma resposta HTTP contendo a lista de objetos {@link Romaneio} e o
     *         status HTTP 200 (OK).
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<Romaneio>> findAll() {

        List<Romaneio> romaneio = this.romaneioFacade.findAll();

        return new ResponseEntity<List<Romaneio>>(romaneio, HttpStatus.OK);

    }

    /**
     * Retorna um romaneio com base no seu identificador único.
     *
     * @param id o identificador único do romaneio a ser encontrado.
     * @return uma resposta HTTP contendo o objeto {@link Romaneio} correspondente e
     *         o status HTTP 200 (OK).
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<Romaneio> findById(@PathVariable long id) {
        Romaneio romaneio = this.romaneioFacade.findById(id);

        return new ResponseEntity<Romaneio>(romaneio, HttpStatus.OK);

    }

    /**
     * Endpoint para obter o número de registros com base em um status específico.
     *
     * @param status o status utilizado como critério de filtragem (ex.: "retirado",
     *               "aguardndo", "finalizado").
     * @return um {@link ResponseEntity} contendo o número de registros que
     *         correspondem ao status fornecido
     *         no corpo da resposta, junto com o status HTTP 200 (OK).
     */
    @GetMapping("/count/sts/{status}")
    public ResponseEntity<ResponceRecord> getCountStsAll(@PathVariable String status) {
        return new ResponseEntity<ResponceRecord>(
                new ResponceRecord(this.romaneioFacade.getCountForStatus(status), status), HttpStatus.OK);
    }

    /**
     * Endpoint para obter a lista de romaneios associados a um motorista
     * específico.
     *
     * @param uid o identificador único do motorista.
     * @return um {@link ResponseEntity} contendo a lista de objetos
     *         {@link Romaneio}
     *         associados ao motorista especificado e o status HTTP 200 (OK).
     */
    @GetMapping("/count/driver/{uid}")
    public ResponseEntity<List<Romaneio>> getCountDriver(@PathVariable long driver) {
        return new ResponseEntity<List<Romaneio>>(this.romaneioFacade.findByMotorista(driver), HttpStatus.OK);
    }

    /**
     * Endpoint para obter a lista de romaneios associados a um entregador
     * específico.
     *
     * @param delivery o identificador único do entregador.
     * @return um {@link ResponseEntity} contendo a lista de objetos
     *         {@link Romaneio}
     *         associados ao entregador especificado e o status HTTP 200 (OK).
     */
    @GetMapping("/count/delivery/{uid}")
    public ResponseEntity<List<Romaneio>> getCountDelivery(@PathVariable long delivery) {
        return new ResponseEntity<List<Romaneio>>(this.romaneioFacade.findByEntregador(delivery), HttpStatus.OK);
    }

    /**
     * Salva um novo romaneio no sistema.
     *
     * @param romaneio o objeto {@link Romaneio} a ser salvo.
     * @return uma resposta HTTP contendo o objeto salvo e o status HTTP 201
     *         (Created).
     */
    @PostMapping("/save")
    public ResponseEntity<Romaneio> save(@RequestBody RomaneioRecord romaneio) {

        Romaneio romaneioSaved = romaneioFacade.save(romaneio);

        return new ResponseEntity<Romaneio>(romaneioSaved, HttpStatus.CREATED);

    }

    /**
     * Atualiza um romaneio existente com base no seu identificador.
     *
     * @param id       o identificador único do romaneio a ser atualizado.
     * @param romaneio os novos dados do romaneio.
     * @return uma resposta HTTP contendo o objeto atualizado e o status HTTP 200
     *         (OK),
     *         ou 404 (Not Found) caso o ID não seja encontrado.
     */
    @PutMapping("/update/id/{id}")
    public ResponseEntity<Romaneio> update(
            @PathVariable long id,
            @RequestBody RomaneioUpdateRecord romaneio) {

        if (this.romaneioFacade.findById(id) == null)
            throw new CustomExceptionService("Romaneio com id " + id + " não encontrado.", 404);

        Romaneio romaneioInb = romaneioFacade.update(id, romaneio);
        return new ResponseEntity<Romaneio>(romaneioInb, HttpStatus.OK);
    }

    /**
     * Atualiza um romaneio existente com base no seu código único.
     *
     * @param codigo   o código único do romaneio a ser atualizado.
     * @param romaneio o objeto {@link RomaneioUpdateRecord} contendo os novos dados
     *                 do romaneio.
     * @return uma resposta HTTP contendo o objeto atualizado e o status HTTP 200
     *         (OK),
     *         ou 404 (Not Found) caso o código não seja encontrado.
     */
    @PutMapping("/update/codigo/{codigo}")
    public ResponseEntity<Romaneio> update(
            @PathVariable String codigo,
            @RequestBody RomaneioUpdateRecord romaneio) {

        if (this.romaneioFacade.findByCodigoUid(codigo) == null)
            throw new CustomExceptionService("Romaneio com codigo " + codigo + " não encontrado.", 404);

        Romaneio romaneioInb = romaneioFacade.update(codigo, romaneio);
        return new ResponseEntity<Romaneio>(romaneioInb, HttpStatus.OK);
    }

    /**
     * Exclui um romaneio com base no seu identificador único.
     *
     * @param id o identificador único do romaneio a ser excluído.
     * @return uma resposta HTTP com o status 200 (OK).
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {

        if (this.romaneioFacade.findById(id) == null)
            throw new CustomExceptionService("Romaneio com id " + id + " não encontrado.", 404);

        romaneioFacade.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /**
     * Retorna uma lista de romaneios com base no status fornecido.
     *
     * @param sts o status utilizado como critério de filtragem.
     * @return uma resposta HTTP contendo a lista de objetos {@link Romaneio}
     *         que correspondem ao status especificado e o status HTTP 200 (OK).
     */

    @GetMapping("/findByStatus/{sts}")
    public ResponseEntity<?> findByStatus(@PathVariable String sts) {

        List<Romaneio> romaneio = this.romaneioFacade.findByStatus(sts);

        if (romaneio == null || romaneio.isEmpty()) {
            throw new CustomExceptionService("Romaneios com status " + sts + " nao encontrado.", 404);
        }

        return new ResponseEntity<List<Romaneio>>(romaneio, HttpStatus.OK);
    }

}

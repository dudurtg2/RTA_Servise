package com.example.empresa.controllers;

import com.example.empresa.entities.Romaneio;
import com.example.empresa.entities.records.ErrorRecord;
import com.example.empresa.entities.records.RomaneioRecord;
import com.example.empresa.entities.records.RomaneioUpdateRecord;
import com.example.empresa.facades.RomaneioFacade;

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
    @GetMapping("/count/{status}")
    public ResponseEntity<Integer> getCount(@PathVariable String status) {
        int count = this.romaneioFacade.getCount(status);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    /**
     * Salva um novo romaneio no sistema.
     *
     * @param romaneio o objeto {@link Romaneio} a ser salvo.
     * @return uma resposta HTTP contendo o objeto salvo e o status HTTP 201
     *         (Created).
     */
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RomaneioRecord romaneio) {

        Romaneio romaneioSaved = romaneioFacade.save(romaneio);

        if (romaneioSaved == null) {
            return new ResponseEntity<ErrorRecord>(new ErrorRecord("Erro ao salvar o romaneio"), HttpStatus.BAD_REQUEST);
        }

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
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(
            @PathVariable long id,
            @RequestBody RomaneioUpdateRecord romaneio) {

        Romaneio romaneioUpdated = romaneioFacade.update(id, romaneio);

        if (romaneioUpdated == null) {
            return new ResponseEntity<ErrorRecord>(new ErrorRecord("Erro ao atualizar o romaneio"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Romaneio>(romaneioUpdated, HttpStatus.OK);
    }

    /**
     * Exclui um romaneio com base no seu identificador único.
     *
     * @param id o identificador único do romaneio a ser excluído.
     * @return uma resposta HTTP com o status 200 (OK).
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        romaneioFacade.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

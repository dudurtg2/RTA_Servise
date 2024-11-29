package com.example.empresa.controllers;

import com.example.empresa.entities.Romaneio;
import com.example.empresa.facades.RomaneioFacade;
import com.example.empresa.records.ErrorRecord;
import com.example.empresa.records.RomaneioRecord;
import com.example.empresa.records.RomaneioUpdateRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
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
        try {
            List<Romaneio> romaneio = this.romaneioFacade.findAll();

            return new ResponseEntity<List<Romaneio>>(romaneio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<List<Romaneio>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Retorna um romaneio com base no seu identificador único.
     *
     * @param id o identificador único do romaneio a ser encontrado.
     * @return uma resposta HTTP contendo o objeto {@link Romaneio} correspondente e
     *         o status HTTP 200 (OK).
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        try {
            Romaneio romaneio = this.romaneioFacade.findById(id);

            return new ResponseEntity<Romaneio>(romaneio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ErrorRecord>(new ErrorRecord("Erro inesperado: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
        try {
            int count = this.romaneioFacade.getCount(status);
            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
        try {
            Romaneio romaneioSaved = romaneioFacade.save(romaneio);
            if (romaneioSaved == null) {
                return new ResponseEntity<ErrorRecord>(new ErrorRecord("Erro ao salvar o romaneio"),
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Romaneio>(romaneioSaved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<ErrorRecord>(new ErrorRecord("Erro inesperado: " + e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
        try {
            Romaneio romaneioUpdated = romaneioFacade.update(id, romaneio);
            if (romaneioUpdated == null) {
                return new ResponseEntity<ErrorRecord>(new ErrorRecord("Erro ao atualizar o romaneio"),
                        HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Romaneio>(romaneioUpdated, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ErrorRecord>(new ErrorRecord("Erro inesperado: " + e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Exclui um romaneio com base no seu identificador único.
     *
     * @param id o identificador único do romaneio a ser excluído.
     * @return uma resposta HTTP com o status 200 (OK).
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        try {
            romaneioFacade.deleteById(id);
        } catch (Exception e) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

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
        try {
            List<Romaneio> romaneio = this.romaneioFacade.findByStatus(sts);

            if (romaneio == null || romaneio.isEmpty()) {
                return new ResponseEntity<ErrorRecord>(new ErrorRecord("Nenhum romaneio encontrado"), HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<Romaneio>>(romaneio, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<ErrorRecord>(new ErrorRecord("Erro inesperado: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

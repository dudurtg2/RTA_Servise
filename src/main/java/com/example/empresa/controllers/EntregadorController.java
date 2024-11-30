package com.example.empresa.controllers;

import com.example.empresa.entities.Entregador;
import com.example.empresa.facades.EntregadorFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * Controlador REST para gerenciar operações relacionadas à entidade
 * {@link Entregador}.
 * Permite realizar operações de CRUD (Create, Read, Update, Delete) sobre os
 * entregadores.
 */
@RestController
@RequestScope
@RequestMapping("/api/entregadores")
public class EntregadorController {

    private EntregadorFacade entregadorFacade;

    /**
     * Construtor para injeção de dependência do {@link EntregadorFacade}.
     *
     * @param entregadorFacade a fachada que gerencia a lógica de negócios para a
     *                         entidade {@link Entregador}.
     */
    @Autowired
    public EntregadorController(EntregadorFacade entregadorFacade) {
        this.entregadorFacade = entregadorFacade;
    }

    /**
     * Retorna a lista de todos os entregadores.
     *
     * @return uma resposta HTTP contendo a lista de objetos {@link Entregador} e o
     *         status HTTP 200 (OK).
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<Entregador>> findAll() {
        List<Entregador> entregadores = this.entregadorFacade.findAll();
        return new ResponseEntity<>(entregadores, HttpStatus.OK);
    }

    /**
     * Retorna um entregador com base no seu identificador único.
     *
     * @param id o identificador único do entregador a ser encontrado.
     * @return uma resposta HTTP contendo o objeto {@link Entregador} correspondente
     *         e o status HTTP 200 (OK).
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<Entregador> findById(@PathVariable long id) {
        Entregador entregador = this.entregadorFacade.findById(id);
        return new ResponseEntity<>(entregador, HttpStatus.OK);
    }

    /**
     * Salva um novo entregador no sistema.
     *
     * @param entregador o objeto {@link Entregador} a ser salvo.
     * @return uma resposta HTTP contendo o objeto salvo e o status HTTP 201
     *         (Created),
     *         ou o status HTTP 409 (Conflict) caso ocorra um problema de
     *         integridade de dados.
     */
    @PostMapping("/save")
    public ResponseEntity<Entregador> save(@RequestBody Entregador entregador) {

        Entregador entregadorSaved = entregadorFacade.save(entregador);
        return new ResponseEntity<>(entregadorSaved, HttpStatus.CREATED);

    }

    /**
     * Atualiza um entregador existente com base no seu identificador.
     *
     * @param id         o identificador único do entregador a ser atualizado.
     * @param entregador os novos dados do entregador.
     * @return uma resposta HTTP contendo o objeto atualizado e o status HTTP 200
     *         (OK),
     *         ou 404 (Not Found) caso o ID não seja encontrado.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Entregador> update(@PathVariable long id, @RequestBody Entregador entregador) {
        Entregador entregadorUpdated = entregadorFacade.update(id, entregador);
        if (entregadorUpdated == null) {
            return new ResponseEntity<>(entregadorUpdated, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(entregadorUpdated, HttpStatus.OK);
    }

    /**
     * Exclui um entregador com base no seu identificador único.
     *
     * @param id o identificador único do entregador a ser excluído.
     * @return uma resposta HTTP com o status 200 (OK).
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        entregadorFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

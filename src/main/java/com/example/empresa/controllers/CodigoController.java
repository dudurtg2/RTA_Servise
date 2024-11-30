package com.example.empresa.controllers;

import com.example.empresa.entities.Codigo;
import com.example.empresa.facades.CodigoFacade;
import com.example.empresa.services.CustomExceptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * Controlador REST para gerenciar operações relacionadas à entidade {@link Codigo}.
 * Permite realizar operações de CRUD (Create, Read, Update, Delete) sobre os códigos.
 */
@RestController
@RequestScope
@RequestMapping("/api/codigos")
public class CodigoController {

    private CodigoFacade codigoFacade;

    /**
     * Construtor para injeção de dependência do {@link CodigoFacade}.
     *
     * @param codigoFacade a fachada que gerencia a lógica de negócios para a entidade {@link Codigo}.
     */
    @Autowired
    public CodigoController(CodigoFacade codigoFacade) {
        this.codigoFacade = codigoFacade;
    }

    /**
     * Retorna a lista de todos os códigos.
     *
     * @return uma resposta HTTP contendo a lista de objetos {@link Codigo} e o status HTTP 200 (OK).
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<Codigo>> findAll() {
        List<Codigo> codigo = this.codigoFacade.findAll();
        return new ResponseEntity<>(codigo, HttpStatus.OK);
    }

    /**
     * Retorna um código com base no seu identificador único.
     *
     * @param id o identificador único do código a ser encontrado.
     * @return uma resposta HTTP contendo o objeto {@link Codigo} correspondente e o status HTTP 200 (OK).
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<Codigo> findById(@PathVariable long id) {
        Codigo codigo = this.codigoFacade.findById(id);
        return new ResponseEntity<>(codigo, HttpStatus.OK);
    }

    /**
     * Salva um novo código no sistema.
     *
     * @param codigo o objeto {@link Codigo} a ser salvo.
     * @return uma resposta HTTP contendo o objeto salvo e o status HTTP 201 (Created).
     */
    @PostMapping("/save")
    public ResponseEntity<Codigo> save(@RequestBody Codigo codigo) {
        Codigo codigoSaved = codigoFacade.save(codigo);
        return new ResponseEntity<>(codigoSaved, HttpStatus.CREATED);
    }

    /**
     * Atualiza um código existente com base no seu identificador.
     *
     * @param id     o identificador único do código a ser atualizado.
     * @param codigo os novos dados do código.
     * @return uma resposta HTTP contendo o objeto atualizado e o status HTTP 200 (OK),
     * ou 404 (Not Found) caso o ID não seja encontrado.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Codigo> update(@PathVariable long id, @RequestBody Codigo codigo) {
        if(this.codigoFacade.findById(id) == null) throw new CustomExceptionService("Codigo com id " + id + " nao encontrada.", 404);
        Codigo codigoUpdated = codigoFacade.update(id, codigo);
        return new ResponseEntity<>(codigoUpdated, HttpStatus.OK);
    }

    /**
     * Exclui um código com base no seu identificador único.
     *
     * @param id o identificador único do código a ser excluído.
     * @return uma resposta HTTP com o status 200 (OK).
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        if(this.codigoFacade.findById(id) == null) throw new CustomExceptionService("Codigo com id " + id + " nao encontrada.", 404);
        codigoFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

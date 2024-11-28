package com.example.empresa.controllers;

import com.example.empresa.entities.Cidade;
import com.example.empresa.facades.CidadeFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * Controlador REST para gerenciar operações relacionadas à entidade {@link Cidade}.
 * Este controlador permite realizar operações de CRUD (Create, Read, Update, Delete)
 * sobre as cidades.
 */
@RestController
@RequestScope
@RequestMapping("/api/cidades")
public class CidadeController {

    private CidadeFacade cidadeFacade;

    /**
     * Construtor para injeção de dependência do {@link CidadeFacade}.
     *
     * @param cidadeFacade a fachada que gerencia a lógica de negócios para a entidade {@link Cidade}.
     */
    @Autowired
    public CidadeController(CidadeFacade cidadeFacade) {
        this.cidadeFacade = cidadeFacade;
    }

    /**
     * Retorna a lista de todas as cidades.
     *
     * @return uma resposta HTTP contendo a lista de objetos {@link Cidade} e o status HTTP 200 (OK).
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<Cidade>> findAll() {
        List<Cidade> cidades = this.cidadeFacade.findAll();
        return new ResponseEntity<>(cidades, HttpStatus.OK);
    }

    /**
     * Retorna uma cidade com base no seu identificador único.
     *
     * @param id o identificador único da cidade a ser encontrada.
     * @return uma resposta HTTP contendo o objeto {@link Cidade} correspondente e o status HTTP 200 (OK).
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<Cidade> findById(@PathVariable int id) {
        Cidade cidade = this.cidadeFacade.findById(id);
        return new ResponseEntity<>(cidade, HttpStatus.OK);
    }

    /**
     * Salva uma nova cidade no sistema.
     *
     * @param cidade o objeto {@link Cidade} a ser salvo.
     * @return uma resposta HTTP contendo o objeto salvo e o status HTTP 201 (Created).
     */
    @PostMapping("/save")
    public ResponseEntity<Cidade> save(@RequestBody Cidade cidade) {
        Cidade cidadeSaved = cidadeFacade.save(cidade);
        return new ResponseEntity<>(cidadeSaved, HttpStatus.CREATED);
    }

    /**
     * Atualiza uma cidade existente com base no seu identificador.
     *
     * @param id     o identificador único da cidade a ser atualizada.
     * @param cidade os novos dados da cidade.
     * @return uma resposta HTTP contendo o objeto atualizado e o status HTTP 200 (OK),
     * ou 404 (Not Found) caso o ID não seja encontrado.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Cidade> update(@PathVariable int id, @RequestBody Cidade cidade) {
        Cidade cidadeUpdated = cidadeFacade.update(id, cidade);
        if (cidadeUpdated == null) {
            return new ResponseEntity<>(cidadeUpdated, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cidadeUpdated, HttpStatus.OK);
    }

    /**
     * Exclui uma cidade com base no seu identificador único.
     *
     * @param id o identificador único da cidade a ser excluída.
     * @return uma resposta HTTP com o status 200 (OK).
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        cidadeFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

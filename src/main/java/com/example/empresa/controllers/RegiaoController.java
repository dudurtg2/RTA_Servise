package com.example.empresa.controllers;

import com.example.empresa.entities.Regiao;
import com.example.empresa.facades.RegiaoFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * Controlador REST para gerenciar operações relacionadas à entidade {@link Regiao}.
 * Permite realizar operações de CRUD (Create, Read, Update, Delete) sobre as regiões.
 */
@RestController
@RequestScope
@RequestMapping("/regioes")
public class RegiaoController {

    private RegiaoFacade regiaoFacade;

    /**
     * Construtor para injeção de dependência do {@link RegiaoFacade}.
     *
     * @param regiaoFacade a fachada que gerencia a lógica de negócios para a entidade {@link Regiao}.
     */
    @Autowired
    public RegiaoController(RegiaoFacade regiaoFacade) {
        this.regiaoFacade = regiaoFacade;
    }

    /**
     * Retorna a lista de todas as regiões.
     *
     * @return uma resposta HTTP contendo a lista de objetos {@link Regiao} e o status HTTP 200 (OK).
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<Regiao>> findAll() {
        List<Regiao> regiao = this.regiaoFacade.findAll();
        return new ResponseEntity<>(regiao, HttpStatus.OK);
    }

    /**
     * Retorna uma região com base no seu identificador único.
     *
     * @param id o identificador único da região a ser encontrada.
     * @return uma resposta HTTP contendo o objeto {@link Regiao} correspondente e o status HTTP 200 (OK).
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<Regiao> findById(@PathVariable int id) {
        Regiao regiao = this.regiaoFacade.findById(id);
        return new ResponseEntity<>(regiao, HttpStatus.OK);
    }

    /**
     * Salva uma nova região no sistema.
     *
     * @param regiao o objeto {@link Regiao} a ser salvo.
     * @return uma resposta HTTP contendo o objeto salvo e o status HTTP 201 (Created).
     */
    @PostMapping("/save")
    public ResponseEntity<Regiao> save(@RequestBody Regiao regiao) {
        Regiao regiaoSaved = regiaoFacade.save(regiao);
        return new ResponseEntity<>(regiaoSaved, HttpStatus.CREATED);
    }

    /**
     * Atualiza uma região existente com base no seu identificador.
     *
     * @param id     o identificador único da região a ser atualizada.
     * @param regiao os novos dados da região.
     * @return uma resposta HTTP contendo o objeto atualizado e o status HTTP 200 (OK),
     * ou 404 (Not Found) caso o ID não seja encontrado.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Regiao> update(@PathVariable int id, @RequestBody Regiao regiao) {
        Regiao regiaoUpdated = regiaoFacade.update(id, regiao);
        if (regiaoUpdated == null) {
            return new ResponseEntity<>(regiaoUpdated, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(regiaoUpdated, HttpStatus.OK);
    }

    /**
     * Exclui uma região com base no seu identificador único.
     *
     * @param id o identificador único da região a ser excluída.
     * @return uma resposta HTTP com o status 200 (OK).
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        regiaoFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

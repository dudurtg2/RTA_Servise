package com.example.empresa.controllers;

import com.example.empresa.entities.Base;
import com.example.empresa.facades.BaseFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlador REST para gerenciar operações relacionadas à entidade {@link Base}.
 * Este controlador lida com requisições relacionadas a bases de operações.
 */
@RestController
@RequestScope
@RequestMapping("/api/bases")
public class BaseController {

    private BaseFacade baseFacade;

    /**
     * Construtor para injeção de dependência do {@link BaseFacade}.
     *
     * @param baseFacade a fachada que gerencia a lógica de negócios para a entidade {@link Base}.
     */
    @Autowired
    public BaseController(BaseFacade baseFacade) {
        this.baseFacade = baseFacade;
    }

    /**
     * Retorna a lista de todas as bases.
     *
     * @return uma resposta HTTP contendo a lista de objetos {@link Base} e o status HTTP 200 (OK).
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<Base>> findAll() {
        List<Base> bases = this.baseFacade.findAll();

        return new ResponseEntity<>(bases, HttpStatus.OK);
        
    }

    /**
     * Retorna uma base com base no seu identificador único.
     *
     * @param id o identificador único da base a ser encontrada.
     * @return uma resposta HTTP contendo o objeto {@link Base} correspondente e o status HTTP 200 (OK).
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<Base> findById(@PathVariable long id) {

        Base base = this.baseFacade.findById(id);
        return new ResponseEntity<>(base, HttpStatus.OK);
        
    }

    /**
     * Salva uma nova base no sistema.
     *
     * @param base o objeto {@link Base} a ser salvo.
     * @return uma resposta HTTP contendo o objeto salvo e o status HTTP 201 (Created).
     */
    @PostMapping("/save")
    public ResponseEntity<Base> save(@RequestBody Base base) {
        Base baseSaved = baseFacade.save(base);
        return new ResponseEntity<>(baseSaved, HttpStatus.CREATED); 
    }

    /**
     * Atualiza uma base existente com base no seu identificador.
     *
     * @param id   o identificador único da base a ser atualizada.
     * @param base os novos dados da base.
     * @return uma resposta HTTP contendo o objeto atualizado e o status HTTP 200 (OK),
     * ou 404 (Not Found) caso o ID não seja encontrado.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Base> update(@PathVariable long id, @RequestBody Base base) {
        
        Base baseUpdated = baseFacade.update(id, base);
        return new ResponseEntity<>(baseUpdated, HttpStatus.OK);
        
    }
    /**
     * Exclui uma base com base no seu identificador único.
     *
     * @param id o identificador único da base a ser excluída.
     * @return uma resposta HTTP com o status 200 (OK).
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        
        baseFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
}

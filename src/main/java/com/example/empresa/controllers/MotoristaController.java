package com.example.empresa.controllers;

import com.example.empresa.entities.Motorista;
import com.example.empresa.facades.MotoristaFacade;
import com.example.empresa.services.CustomExceptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * Controlador REST para gerenciar operações relacionadas à entidade {@link Motorista}.
 * Permite realizar operações de CRUD (Create, Read, Update, Delete) sobre os motoristas.
 */
@RestController
@RequestScope
@RequestMapping("/api/motoristas")
public class MotoristaController {

    private MotoristaFacade motoristaFacade;

    /**
     * Construtor para injeção de dependência do {@link MotoristaFacade}.
     *
     * @param motoristaFacade a fachada que gerencia a lógica de negócios para a entidade {@link Motorista}.
     */
    @Autowired
    public MotoristaController(MotoristaFacade motoristaFacade) {
        this.motoristaFacade = motoristaFacade;
    }

    /**
     * Retorna a lista de todos os motoristas.
     *
     * @return uma resposta HTTP contendo a lista de objetos {@link Motorista} e o status HTTP 200 (OK).
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<Motorista>> findAll() {
        List<Motorista> motoristas = this.motoristaFacade.findAll();
        return new ResponseEntity<>(motoristas, HttpStatus.OK);
    }

    /**
     * Retorna um motorista com base no seu identificador único.
     *
     * @param id o identificador único do motorista a ser encontrado.
     * @return uma resposta HTTP contendo o objeto {@link Motorista} correspondente e o status HTTP 200 (OK).
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<Motorista> findById(@PathVariable long id) {
        Motorista motorista = this.motoristaFacade.findById(id);
        return new ResponseEntity<>(motorista, HttpStatus.OK);
    }

    /**
     * Salva um novo motorista no sistema.
     *
     * @param motorista o objeto {@link Motorista} a ser salvo.
     * @return uma resposta HTTP contendo o objeto salvo e o status HTTP 201 (Created),
     * ou o status HTTP 409 (Conflict) caso ocorra um problema de integridade de dados.
     */
    @PostMapping("/save")
    public ResponseEntity<Motorista> save(@RequestBody Motorista motorista) {
        
        Motorista motoristaSaved = motoristaFacade.save(motorista);
        return new ResponseEntity<>(motoristaSaved, HttpStatus.CREATED);
        
    }

    /**
     * Atualiza um motorista existente com base no seu identificador.
     *
     * @param id       o identificador único do motorista a ser atualizado.
     * @param motorista os novos dados do motorista.
     * @return uma resposta HTTP contendo o objeto atualizado e o status HTTP 200 (OK),
     * ou 404 (Not Found) caso o ID não seja encontrado.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Motorista> update(@PathVariable long id, @RequestBody Motorista motorista) {
        if (this.motoristaFacade.findById(id) == null) throw new CustomExceptionService("Motorista com id " + id + " nao encontrada.", 404);
        Motorista motoristaUpdated = motoristaFacade.update(id, motorista);
        return new ResponseEntity<>(motoristaUpdated, HttpStatus.OK);
    }

    /**
     * Exclui um motorista com base no seu identificador único.
     *
     * @param id o identificador único do motorista a ser excluído.
     * @return uma resposta HTTP com o status 200 (OK).
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        if (this.motoristaFacade.findById(id) == null) throw new CustomExceptionService("Motorista com id " + id + " nao encontrada.", 404);
        motoristaFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

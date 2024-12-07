package com.example.empresa.controllers;

import com.example.empresa.entities.Entregador;
import com.example.empresa.facades.EntregadorFacade;
import com.example.empresa.services.ErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/api/entregadores")
public class EntregadorController {

    private EntregadorFacade entregadorFacade;

    @Autowired
    public EntregadorController(EntregadorFacade entregadorFacade) {
        this.entregadorFacade = entregadorFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Entregador>> findAll() {
        List<Entregador> entregadores = this.entregadorFacade.findAll();
        return new ResponseEntity<>(entregadores, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Entregador> findById(@PathVariable long id) {
        Entregador entregador = this.entregadorFacade.findById(id);
        return new ResponseEntity<>(entregador, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Entregador> save(@RequestBody Entregador entregador) {

        Entregador entregadorSaved = entregadorFacade.save(entregador);
        return new ResponseEntity<>(entregadorSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Entregador> update(@PathVariable long id, @RequestBody Entregador entregador) {
        if (this.entregadorFacade.findById(id) == null) throw new ErrorException("Entregador com id " + id + " nao encontrada.", 404);
        Entregador entregadorUpdated = entregadorFacade.update(id, entregador);
        return new ResponseEntity<>(entregadorUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        if (this.entregadorFacade.findById(id) == null) throw new ErrorException("Entregador com id " + id + " nao encontrada.", 404);
        entregadorFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


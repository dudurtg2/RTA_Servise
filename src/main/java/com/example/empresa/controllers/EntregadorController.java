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

@RestController
@RequestScope
@RequestMapping("/entregadores")
public class EntregadorController {

    private EntregadorFacade entregadorFacade;

    @Autowired
    public EntregadorController(EntregadorFacade entregadorFacade) {
        this.entregadorFacade = entregadorFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Entregador>> findAll() {
        List<Entregador> entregadores = this.entregadorFacade.findAll();

        return new ResponseEntity<List<Entregador>>(entregadores, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Entregador> findById(@PathVariable int id) {
        Entregador entregador = this.entregadorFacade.findById(id);
        
        return new ResponseEntity<Entregador>(entregador, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Entregador entregador) {
        try {
            Entregador entregadorSaved = entregadorFacade.save(entregador);
            return new ResponseEntity<Entregador>(entregadorSaved, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<Boolean>(false , HttpStatus.CONFLICT);
        } 
   
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Entregador> update(
            @PathVariable int id,
            @RequestBody Entregador entregador) {

            Entregador entregadorUpdated = entregadorFacade.update(id, entregador);

            if (entregadorUpdated == null)
                return new ResponseEntity<Entregador>(entregadorUpdated, HttpStatus.NOT_FOUND);

            return new ResponseEntity<Entregador>(entregadorUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        entregadorFacade.deleteById(id);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

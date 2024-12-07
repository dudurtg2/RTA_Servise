package com.example.empresa.controllers;

import com.example.empresa.entities.Motorista;
import com.example.empresa.facades.MotoristaFacade;
import com.example.empresa.services.ErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/api/motoristas")
public class MotoristaController {

    private MotoristaFacade motoristaFacade;

    @Autowired
    public MotoristaController(MotoristaFacade motoristaFacade) {
        this.motoristaFacade = motoristaFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Motorista>> findAll() {
        List<Motorista> motoristas = this.motoristaFacade.findAll();
        return new ResponseEntity<>(motoristas, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Motorista> findById(@PathVariable long id) {
        Motorista motorista = this.motoristaFacade.findById(id);
        return new ResponseEntity<>(motorista, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Motorista> save(@RequestBody Motorista motorista) {
        Motorista motoristaSaved = motoristaFacade.save(motorista);
        return new ResponseEntity<>(motoristaSaved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Motorista> update(@PathVariable long id, @RequestBody Motorista motorista) {
        if (this.motoristaFacade.findById(id) == null) throw new ErrorException("Motorista com id " + id + " nao encontrada.", 404);
        Motorista motoristaUpdated = motoristaFacade.update(id, motorista);
        return new ResponseEntity<>(motoristaUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        if (this.motoristaFacade.findById(id) == null) throw new ErrorException("Motorista com id " + id + " nao encontrada.", 404);
        motoristaFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


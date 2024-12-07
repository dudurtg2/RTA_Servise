package com.example.empresa.controllers;

import com.example.empresa.entities.Codigo;
import com.example.empresa.facades.CodigoFacade;
import com.example.empresa.services.ErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/api/codigos")
public class CodigoController {

    private CodigoFacade codigoFacade;

    @Autowired
    public CodigoController(CodigoFacade codigoFacade) {
        this.codigoFacade = codigoFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Codigo>> findAll() {
        List<Codigo> codigo = this.codigoFacade.findAll();
        return new ResponseEntity<>(codigo, HttpStatus.OK);
    }

    @GetMapping("/findByEntregadorId/{entregador}")
    public ResponseEntity<List<Codigo>> findByEntregadorId(@PathVariable long entregador) {
        List<Codigo> codigo = this.codigoFacade.findByEntregadorId(entregador);
        return new ResponseEntity<>(codigo, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Codigo> findById(@PathVariable long id) {
        Codigo codigo = this.codigoFacade.findById(id);
        return new ResponseEntity<>(codigo, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Codigo> save(@RequestBody Codigo codigo) {
        Codigo codigoSaved = codigoFacade.save(codigo);
        return new ResponseEntity<>(codigoSaved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Codigo> update(@PathVariable long id, @RequestBody Codigo codigo) {
        if(this.codigoFacade.findById(id) == null) throw new ErrorException("Codigo com id " + id + " nao encontrada.", 404);
        Codigo codigoUpdated = codigoFacade.update(id, codigo);
        return new ResponseEntity<>(codigoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        if(this.codigoFacade.findById(id) == null) throw new ErrorException("Codigo com id " + id + " nao encontrada.", 404);
        codigoFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


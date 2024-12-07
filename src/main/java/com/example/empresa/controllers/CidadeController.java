package com.example.empresa.controllers;

import com.example.empresa.entities.Cidade;
import com.example.empresa.facades.CidadeFacade;
import com.example.empresa.services.ErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/api/cidades")
public class CidadeController {

    private CidadeFacade cidadeFacade;

    @Autowired
    public CidadeController(CidadeFacade cidadeFacade) {
        this.cidadeFacade = cidadeFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Cidade>> findAll() {
        List<Cidade> cidades = this.cidadeFacade.findAll();
        return new ResponseEntity<>(cidades, HttpStatus.OK);
        
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Cidade> findById(@PathVariable long id) {
        Cidade cidade = this.cidadeFacade.findById(id);
        return new ResponseEntity<>(cidade, HttpStatus.OK);
        
    }

    @PostMapping("/save")
    public ResponseEntity<Cidade> save(@RequestBody Cidade cidade) {
        Cidade cidadeSaved = cidadeFacade.save(cidade);
        return new ResponseEntity<>(cidadeSaved, HttpStatus.CREATED);
        
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cidade> update(@PathVariable long id, @RequestBody Cidade cidade) {

        if(this.cidadeFacade.findById(id) == null) throw new ErrorException("Cidade com id " + id + " nao encontrada.", 404);

        Cidade cidadeUpdated = cidadeFacade.update(id, cidade);
        return new ResponseEntity<>(cidadeUpdated, HttpStatus.OK);
    
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        
        if(this.cidadeFacade.findById(id) == null) throw new ErrorException("Cidade com id " + id + " nao encontrada.", 404);

        this.cidadeFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
        
    }
}


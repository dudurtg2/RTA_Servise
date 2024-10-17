package com.example.empresa.controllers;

import com.example.empresa.entities.Historico;
import com.example.empresa.facades.HistoricoFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/historicos")
public class HistoricoController {

    private HistoricoFacade historicoFacade;

    @Autowired
    public HistoricoController(HistoricoFacade historicoFacade) {
        this.historicoFacade = historicoFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Historico>> findAll() {
        List<Historico> historicos = this.historicoFacade.findAll();

        return new ResponseEntity<List<Historico>>(historicos, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Historico> findById(@PathVariable int id) {
        Historico historico = this.historicoFacade.findById(id);

        return new ResponseEntity<Historico>(historico, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Historico> save(@RequestBody Historico historico) {
        Historico historicoSaved = historicoFacade.save(historico);

        return new ResponseEntity<Historico>(historicoSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Historico> update(
            @PathVariable int id,
            @RequestBody Historico historico) {

        Historico historicoUpdated = historicoFacade.update(id, historico);

        if (historicoUpdated == null) {
            return new ResponseEntity<Historico>(historicoUpdated, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Historico>(historicoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        historicoFacade.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

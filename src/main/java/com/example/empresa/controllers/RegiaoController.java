package com.example.empresa.controllers;

import com.example.empresa.entities.Regiao;
import com.example.empresa.facades.RegiaoFacade;
import com.example.empresa.services.ErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/api/regioes")
public class RegiaoController {

    private RegiaoFacade regiaoFacade;

    @Autowired
    public RegiaoController(RegiaoFacade regiaoFacade) {
        this.regiaoFacade = regiaoFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Regiao>> findAll() {
        List<Regiao> regiao = this.regiaoFacade.findAll();
        return new ResponseEntity<>(regiao, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Regiao> findById(@PathVariable long id) {
        Regiao regiao = this.regiaoFacade.findById(id);
        return new ResponseEntity<>(regiao, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Regiao> save(@RequestBody Regiao regiao) {
        Regiao regiaoSaved = regiaoFacade.save(regiao);
        return new ResponseEntity<>(regiaoSaved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Regiao> update(@PathVariable long id, @RequestBody Regiao regiao) {
        if (this.regiaoFacade.findById(id) == null) throw new ErrorException("Regiao com id " + id + " nao encontrada.", 404);
        Regiao regiaoUpdated = regiaoFacade.update(id, regiao);
        return new ResponseEntity<>(regiaoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        if (this.regiaoFacade.findById(id) == null) throw new ErrorException("Regiao com id " + id + " nao encontrada.", 404);
        regiaoFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


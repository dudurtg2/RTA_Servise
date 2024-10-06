package com.example.empresa.controllers;

import com.example.empresa.entities.Cidade;
import com.example.empresa.facades.CidadeFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private CidadeFacade cidadeFacade;

    @Autowired
    public CidadeController(CidadeFacade cidadeFacade) {
        this.cidadeFacade = cidadeFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Cidade>> findAll() {
        List<Cidade> cidades = this.cidadeFacade.findAll();

        return new ResponseEntity<List<Cidade>>(cidades, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Cidade> findById(@PathVariable int id) {
        Cidade cidade = this.cidadeFacade.findById(id);
        
        return new ResponseEntity<Cidade>(cidade, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Cidade> save(@RequestBody Cidade cidade) {
        Cidade cidadeSaved = cidadeFacade.save(cidade);

        return new ResponseEntity<Cidade>(cidadeSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Cidade> update(
            @PathVariable int id,
            @RequestBody Cidade cidade) {

            Cidade cidadeUpdated = cidadeFacade.update(id, cidade);

            if (cidadeUpdated == null)
                return new ResponseEntity<Cidade>(cidadeUpdated, HttpStatus.NOT_FOUND);

            return new ResponseEntity<Cidade>(cidadeUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        cidadeFacade.deleteById(id);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

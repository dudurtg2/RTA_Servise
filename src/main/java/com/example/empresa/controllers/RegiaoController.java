package com.example.empresa.controllers;

import com.example.empresa.entities.Regiao;
import com.example.empresa.facades.RegiaoFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/regioes")
public class RegiaoController {

    private RegiaoFacade regiaoFacade;

    @Autowired
    public RegiaoController(RegiaoFacade regiaoFacade) {
        this.regiaoFacade = regiaoFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Regiao>> findAll() {
        List<Regiao> regiao = this.regiaoFacade.findAll();

        return new ResponseEntity<List<Regiao>>(regiao, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Regiao> findById(@PathVariable int id) {
        Regiao regiao = this.regiaoFacade.findById(id);
        
        return new ResponseEntity<Regiao>(regiao, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Regiao> save(@RequestBody Regiao regiao) {
        Regiao regiaoSaved = regiaoFacade.save(regiao);

        return new ResponseEntity<Regiao>(regiaoSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Regiao> update(
            @PathVariable int id,
            @RequestBody Regiao regiao) {

                Regiao regiaoUpdated = regiaoFacade.update(id, regiao);

            if (regiaoUpdated == null)
                return new ResponseEntity<Regiao>(regiaoUpdated, HttpStatus.NOT_FOUND);

            return new ResponseEntity<Regiao>(regiaoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        regiaoFacade.deleteById(id);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

package com.example.empresa.controllers;

import com.example.empresa.entities.Codigo;
import com.example.empresa.facades.CodigoFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/codigos")
public class CodigoController {

    private CodigoFacade codigoFacade;

    @Autowired
    public CodigoController(CodigoFacade codigoFacade) {
        this.codigoFacade = codigoFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Codigo>> findAll() {
        List<Codigo> Codigo = this.codigoFacade.findAll();

        return new ResponseEntity<List<Codigo>>(Codigos, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Codigo> findById(@PathVariable int id) {
        Codigo codigo = this.codigoFacade.findById(id);
        
        return new ResponseEntity<Codigo>(codigo, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Codigo> save(@RequestBody Codigo base) {
        Codigo codigoSaved = codigoFacade.save(base);

        return new ResponseEntity<Codigo>(codigoSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Codigo> update(
            @PathVariable int id,
            @RequestBody Codigo codigo) {

            Codigo codigoUpdated = codigoFacade.update(id, codigo);

            if (codigoUpdated == null)
                return new ResponseEntity<Codigo>(codigoUpdated, HttpStatus.NOT_FOUND);

            return new ResponseEntity<Codigo>(codigoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        codigoFacade.deleteById(id);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

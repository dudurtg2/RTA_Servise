package com.example.empresa.controllers;

import com.example.empresa.entities.Funcionario;
import com.example.empresa.entities.Motorista;
import com.example.empresa.facades.MotoristaFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/motoristas")
public class MotoristaController {

    private MotoristaFacade motoristaFacade;

    @Autowired
    public MotoristaController(MotoristaFacade motoristaFacade) {
        this.motoristaFacade = motoristaFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Motorista>> findAll() {
        List<Motorista> motoristas = this.motoristaFacade.findAll();

        return new ResponseEntity<List<Motorista>>(motoristas, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Motorista> findById(@PathVariable int id) {
        Motorista motorista = this.motoristaFacade.findById(id);
        
        return new ResponseEntity<Motorista>(motorista, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Motorista motorista) {
        try {
            Motorista motoristaSaved = motoristaFacade.save(motorista);
            return new ResponseEntity<Motorista>(motoristaSaved, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<Boolean>(false , HttpStatus.CONFLICT);
        } 

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Motorista> update(
            @PathVariable int id,
            @RequestBody Motorista motorista) {

            Motorista motoristaUpdated = motoristaFacade.update(id, motorista);

            if (motoristaUpdated == null)
                return new ResponseEntity<Motorista>(motoristaUpdated, HttpStatus.NOT_FOUND);

            return new ResponseEntity<Motorista>(motoristaUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        motoristaFacade.deleteById(id);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

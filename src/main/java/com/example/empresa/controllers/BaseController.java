package com.example.empresa.controllers;

import com.example.empresa.entities.Base;
import com.example.empresa.facades.BaseFacade;
import com.example.empresa.services.ErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/api/bases")
public class BaseController {

    private BaseFacade baseFacade;

    @Autowired
    public BaseController(BaseFacade baseFacade) {
        this.baseFacade = baseFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Base>> findAll() {
        List<Base> bases = this.baseFacade.findAll();

        return new ResponseEntity<>(bases, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Base> findById(@PathVariable long id) {

        Base base = this.baseFacade.findById(id);
        return new ResponseEntity<>(base, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Base> save(@RequestBody Base base) {
        Base baseSaved = baseFacade.save(base);
        return new ResponseEntity<>(baseSaved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Base> update(@PathVariable long id, @RequestBody Base base) {
        if(this.baseFacade.findById(id) == null) throw new ErrorException("Base com id " + id + " nao encontrada.", 404);
        
        Base baseUpdated = baseFacade.update(id, base);
        return new ResponseEntity<>(baseUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        if(this.baseFacade.findById(id) == null) throw new ErrorException("Base com id " + id + " nao encontrada.", 404);
        
        baseFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


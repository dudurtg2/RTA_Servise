package com.example.empresa.controllers;

import com.example.empresa.entities.Base;
import com.example.empresa.facades.BaseFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bases")
public class BaseController {

    private BaseFacade baseFacade;

    @Autowired
    public BaseController(BaseFacade baseFacade) {
        this.baseFacade = baseFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Base>> findAll() {
        List<Base> bases = this.baseFacade.findAll();

        return new ResponseEntity<List<Base>>(bases, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Base> findById(@PathVariable int id) {
        Base Base = this.baseFacade.findById(id);
        
        return new ResponseEntity<Base>(Base, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Base> save(@RequestBody Base base) {
        Base baseSaved = baseFacade.save(base);

        return new ResponseEntity<Base>(baseSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Base> update(
            @PathVariable int id,
            @RequestBody Base base) {

            Base baseUpdated = baseFacade.update(id, base);

            if (baseUpdated == null)
                return new ResponseEntity<Base>(baseUpdated, HttpStatus.NOT_FOUND);

            return new ResponseEntity<Base>(baseUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        baseFacade.deleteById(id);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

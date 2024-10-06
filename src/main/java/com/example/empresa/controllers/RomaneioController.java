package com.example.empresa.controllers;

import com.example.empresa.entities.Romaneio;
import com.example.empresa.facades.RomaneioFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/romaneios")
public class RomaneioController {

    private RomaneioFacade romaneioFacade;

    @Autowired
    public RomaneioController(RomaneioFacade romaneioFacade) {
        this.romaneioFacade = romaneioFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Romaneio>> findAll() {
        List<Romaneio> romaneio = this.romaneioFacade.findAll();

        return new ResponseEntity<List<Romaneio>>(romaneio, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Romaneio> findById(@PathVariable int id) {
        Romaneio romaneio = this.romaneioFacade.findById(id);
        
        return new ResponseEntity<Romaneio>(romaneio, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Romaneio> save(@RequestBody Romaneio romaneio) {
        Romaneio romaneioSaved = romaneioFacade.save(romaneio);

        return new ResponseEntity<Romaneio>(romaneioSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Romaneio> update(
            @PathVariable int id,
            @RequestBody Romaneio romaneio) {

                Romaneio RomaneioUpdated = romaneioFacade.update(id, romaneio);

            if (RomaneioUpdated == null)
                return new ResponseEntity<Romaneio>(RomaneioUpdated, HttpStatus.NOT_FOUND);

            return new ResponseEntity<Romaneio>(RomaneioUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        romaneioFacade.deleteById(id);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

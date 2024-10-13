package com.example.empresa.controllers;

import com.example.empresa.entities.Empresa;
import com.example.empresa.facades.EmpresaFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/empresas")
public class EmpresaController {

    private EmpresaFacade empresaFacade;

    @Autowired
    public EmpresaController(EmpresaFacade empresaFacade) {
        this.empresaFacade = empresaFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Empresa>> findAll() {
        List<Empresa> empresas = this.empresaFacade.findAll();

        return new ResponseEntity<List<Empresa>>(empresas, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable int id) {
        Empresa empresa = this.empresaFacade.findById(id);
        
        return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Empresa empresa) {
         try {
            Empresa empresaSaved = empresaFacade.save(empresa);
            return new ResponseEntity<Empresa>(empresaSaved, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<Boolean>(false , HttpStatus.CONFLICT);
        } 

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Empresa> update(
            @PathVariable int id,
            @RequestBody Empresa empresa) {

            Empresa empresaUpdated = empresaFacade.update(id, empresa);

            if (empresaUpdated == null)
                return new ResponseEntity<Empresa>(empresaUpdated, HttpStatus.NOT_FOUND);

            return new ResponseEntity<Empresa>(empresaUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        empresaFacade.deleteById(id);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

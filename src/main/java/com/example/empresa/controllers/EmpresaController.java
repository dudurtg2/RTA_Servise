package com.example.empresa.controllers;

import com.example.empresa.entities.Empresa;
import com.example.empresa.facades.EmpresaFacade;
import com.example.empresa.services.ErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/api/empresas")
public class EmpresaController {

    private EmpresaFacade empresaFacade;

    @Autowired
    public EmpresaController(EmpresaFacade empresaFacade) {
        this.empresaFacade = empresaFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Empresa>> findAll() {
        List<Empresa> empresas = this.empresaFacade.findAll();
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable long id) {
        Empresa empresa = this.empresaFacade.findById(id);
        return new ResponseEntity<>(empresa, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Empresa> save(@RequestBody Empresa empresa) {
        Empresa empresaSaved = empresaFacade.save(empresa);
        return new ResponseEntity<>(empresaSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Empresa> update(@PathVariable long id, @RequestBody Empresa empresa) {
        if (this.empresaFacade.findById(id) == null) throw new ErrorException("Empresa com id " + id + " nao encontrada.", 404);    
        Empresa empresaUpdated = empresaFacade.update(id, empresa);
        return new ResponseEntity<>(empresaUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        if (this.empresaFacade.findById(id) == null) throw new ErrorException("Empresa com id " + id + " nao encontrada.", 404);   
        empresaFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


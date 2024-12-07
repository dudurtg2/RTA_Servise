package com.example.empresa.controllers;

import com.example.empresa.entities.Funcionario;
import com.example.empresa.facades.FuncionarioFacade;
import com.example.empresa.services.ErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

@RestController
@RequestScope
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private FuncionarioFacade funcionarioFacade;

    @Autowired
    public FuncionarioController(FuncionarioFacade funcionarioFacade) {
        this.funcionarioFacade = funcionarioFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> funcionarios = this.funcionarioFacade.findAll();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable long id) {
        Funcionario funcionario = this.funcionarioFacade.findById(id);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Funcionario> save(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioSaved = funcionarioFacade.save(funcionario);
        return new ResponseEntity<>(funcionarioSaved, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable long id, @RequestBody Funcionario funcionario) {
        if (this.funcionarioFacade.findById(id) == null) throw new ErrorException("Funcionario com id " + id + " nao encontrada.", 404);
        Funcionario funcionarioUpdated = funcionarioFacade.update(id, funcionario);
        return new ResponseEntity<>(funcionarioUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        if (this.funcionarioFacade.findById(id) == null) throw new ErrorException("Funcionario com id " + id + " nao encontrada.", 404);
        funcionarioFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


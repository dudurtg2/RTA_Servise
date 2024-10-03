package com.example.empresa.controllers;

import com.example.empresa.entities.Funcionario;
import com.example.empresa.facades.FuncionarioFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private FuncionarioFacade funcionarioFacade;

    @Autowired
    public FuncionarioController(FuncionarioFacade funcionarioFacade) {
        this.funcionarioFacade = funcionarioFacade;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> funcionarios = this.funcionarioFacade.findAll();

        return new ResponseEntity<List<Funcionario>>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable int id) {
        Funcionario Funcionario = this.funcionarioFacade.findById(id);
        
        return new ResponseEntity<Funcionario>(Funcionario, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Funcionario> save(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioSaved = funcionarioFacade.save(funcionario);

        return new ResponseEntity<Funcionario>(funcionarioSaved, HttpStatus.CREATED);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Funcionario> update(
            @PathVariable int id,
            @RequestBody Funcionario funcionario) {

            Funcionario funcionarioUpdated = funcionarioFacade.update(id, funcionario);

            if (funcionarioUpdated == null)
                return new ResponseEntity<Funcionario>(funcionarioUpdated, HttpStatus.NOT_FOUND);

            return new ResponseEntity<Funcionario>(funcionarioUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        funcionarioFacade.deleteById(id);
        
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}

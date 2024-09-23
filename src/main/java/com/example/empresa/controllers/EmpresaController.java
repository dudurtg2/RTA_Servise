package com.example.empresa.controllers;

import com.example.empresa.entities.Empresa;
import com.example.empresa.facades.EmpresaFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaFacade empresaFacade;


    @GetMapping("/findAll")
    public List<Empresa> findAll() {
        return empresaFacade.findAll();
    }

    @GetMapping("/findById/{id}")
    public Empresa findById(@PathVariable int id) {
        return empresaFacade.findById(id);
    }

    @PostMapping("/save")
    public Empresa save(
            @RequestParam String nome,
            @RequestParam String cnpj) {

        Empresa novaEmpresa = new Empresa();
        novaEmpresa.setNome(nome);
        novaEmpresa.setCnpj(cnpj);

        return empresaFacade.save(novaEmpresa);
    }

    @PutMapping("/update/{id}")
    public Empresa update(
            @PathVariable int id,
            @RequestParam String nome,
            @RequestParam String cnpj) {

        Empresa empresa = empresaFacade.findById(id);

        if (empresa != null) {
            empresa.setNome(nome);
            empresa.setCnpj(cnpj);
            return empresaFacade.update(id, empresa);
        }
        return null;
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable int id) {
        empresaFacade.deleteById(id);
    }
}

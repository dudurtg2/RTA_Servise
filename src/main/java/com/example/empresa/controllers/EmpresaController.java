package com.example.empresa.controllers;

import com.example.empresa.entities.Empresa;
import com.example.empresa.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/buscarTodos")
    public List<Empresa> buscarTodos() {
        return empresaRepository.buscarTodos();
    }

    @GetMapping("/buscarPorId/{id}")
    public Empresa buscarPorId(@PathVariable int id) {
        return empresaRepository.buscarPorId(id);
    }

    @GetMapping("/gravar")
    public Empresa gravar(
            @RequestParam String nome,
            @RequestParam String cnpj) {

        Empresa novaEmpresa = new Empresa();
        novaEmpresa.setNome(nome);
        novaEmpresa.setCnpj(cnpj);

        return empresaRepository.gravar(novaEmpresa);
    }

    @GetMapping("/atualizar/id={id}")
    public Empresa atualizar(
            @PathVariable int id,
            @RequestParam String nome,
            @RequestParam String cnpj) {

        Empresa empresa = empresaRepository.buscarPorId(id);

        if (empresa != null) {
            empresa.setNome(nome);
            empresa.setCnpj(cnpj);
            return empresaRepository.atualizar(id, empresa);
        }
        return null;
    }

    @GetMapping("/excluir/{id}")
    public void excluir(@PathVariable int id) {
        empresaRepository.excluir(id);
    }
}

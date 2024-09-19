package com.example.empresa.controllers;

import com.example.empresa.applications.EmpresaApplication;
import com.example.empresa.entities.Empresa;
import com.example.empresa.facades.EmpresaFacade;
import com.example.empresa.repositories.EmpresaRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private static EmpresaRepository empresaRepository;
    private static EmpresaApplication empresaApplication;
    private static EmpresaFacade empresaFacade;

    public static void resolverDependencias() {
        empresaRepository = new EmpresaRepository();
        empresaApplication = new EmpresaApplication(empresaRepository);
        empresaFacade = new EmpresaFacade(empresaApplication);
    }
    public EmpresaController() {
        resolverDependencias();
    }

    @GetMapping("/buscarTodos")
    public List<Empresa> buscarTodos() {
        return empresaFacade.buscarTodos();
    }

    @GetMapping("/buscarPorId/{id}")
    public Empresa buscarPorId(@PathVariable int id) {
        return empresaFacade.buscarPorId(id);
    }

    @PostMapping("/gravar")
    public Empresa gravar(
            @RequestParam String nome,
            @RequestParam String cnpj) {

        Empresa novaEmpresa = new Empresa();
        novaEmpresa.setNome(nome);
        novaEmpresa.setCnpj(cnpj);

        return empresaFacade.gravar(novaEmpresa);
    }

    @PutMapping("/atualizar/{id}")
    public Empresa atualizar(
            @PathVariable int id,
            @RequestParam String nome,
            @RequestParam String cnpj) {

        Empresa empresa = empresaFacade.buscarPorId(id);

        if (empresa != null) {
            empresa.setNome(nome);
            empresa.setCnpj(cnpj);
            return empresaFacade.atualizar(id, empresa);
        }
        return null;
    }

    @DeleteMapping("/excluir/{id}")
    public void excluir(@PathVariable int id) {
        empresaFacade.excluir(id);
    }
}

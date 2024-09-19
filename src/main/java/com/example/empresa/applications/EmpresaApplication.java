package com.example.empresa.applications;

import com.example.empresa.repositories.EmpresaRepository;
import com.example.empresa.entities.Empresa;

import java.util.List;


public class EmpresaApplication {
    private EmpresaRepository empresaRepository;

    public EmpresaApplication(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }
    
    
    public List<Empresa> buscarTodos() {
        return this.empresaRepository.buscarTodos();
    }

    
    public Empresa buscarPorId(int id) {
        return this.empresaRepository.buscarPorId(id);
    }

    
    public Empresa gravar(Empresa Empresa) {
        return this.empresaRepository.gravar(Empresa);
    }

    
    public Empresa atualizar(int id, Empresa Empresa) {
        return this.empresaRepository.atualizar(id, Empresa);
    }

    
    public void excluir(int id) {
        this.empresaRepository.excluir(id);
    }


   
}

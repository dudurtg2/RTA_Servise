package com.example.empresa.applications;

import com.example.empresa.repositories.EmpresaRepository;
import com.example.empresa.entities.Empresa;

import java.util.List;


public class EmpresaApplication {
    EmpresaRepository EmpresaRepository = new EmpresaRepository();
    
    public List<Empresa> buscarTodos() {
        return this.EmpresaRepository.buscarTodos();
    }

    
    public Empresa buscarPorId(int id) {
        return this.EmpresaRepository.buscarPorId(id);
    }

    
    public Empresa gravar(Empresa Empresa) {
        return this.EmpresaRepository.gravar(Empresa);
    }

    
    public Empresa atualizar(int id, Empresa Empresa) {
        return this.EmpresaRepository.atualizar(id, Empresa);
    }

    
    public void excluir(int id) {
        this.EmpresaRepository.excluir(id);
    }


   
}

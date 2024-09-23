package com.example.empresa.applications;

import com.example.empresa.entities.Empresa;
import com.example.empresa.interfaces.IEmpresaRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmpresaApplication {
    
    private IEmpresaRepository empresaRepository;

    public EmpresaApplication(IEmpresaRepository empresaRepository) {
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

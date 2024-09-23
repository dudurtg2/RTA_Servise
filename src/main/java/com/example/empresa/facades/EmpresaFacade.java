package com.example.empresa.facades;

import com.example.empresa.applications.EmpresaApplication;
import com.example.empresa.entities.Empresa;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmpresaFacade {
    private EmpresaApplication empresaApplication;
    
    public EmpresaFacade(EmpresaApplication empresaApplication) {
        this.empresaApplication = empresaApplication;
    }
    
    
    public List<Empresa> buscarTodos() {
        return this.empresaApplication.buscarTodos();
    }

    
    public Empresa buscarPorId(int id) {
        return this.empresaApplication.buscarPorId(id);
    }

    
    public Empresa gravar(Empresa Empresa) {
        return this.empresaApplication.gravar(Empresa);
    }

    
    public Empresa atualizar(int id, Empresa Empresa) {
        return this.empresaApplication.atualizar(id, Empresa);
    }

    
    public void excluir(int id) {
        this.empresaApplication.excluir(id);
    }


   
}

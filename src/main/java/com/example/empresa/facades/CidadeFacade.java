package com.example.empresa.facades;

import com.example.empresa.applications.CidadeApplication;
import com.example.empresa.entities.Cidade;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CidadeFacade {
    private CidadeApplication cidadeApplication;

    public CidadeFacade(CidadeApplication cidadeApplication) {
        this.cidadeApplication = cidadeApplication;
    }
    
    public List<Cidade> buscarTodos() {
        return this.cidadeApplication.buscarTodos();
    }

    
    public Cidade buscarPorId(int id) {
        return this.cidadeApplication.buscarPorId(id);
    }

    
    public Cidade gravar(Cidade Cidade) {
        return this.cidadeApplication.gravar(Cidade);
    }

    
    public Cidade atualizar(int id, Cidade Cidade) {
        return this.cidadeApplication.atualizar(id, Cidade);
    }

    
    public void excluir(int id) {
        this.cidadeApplication.excluir(id);
    }


   
}

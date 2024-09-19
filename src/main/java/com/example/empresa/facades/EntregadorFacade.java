package com.example.empresa.facades;

import com.example.empresa.applications.EntregadorApplication;
import com.example.empresa.entities.Entregador;

import java.util.List;


public class EntregadorFacade {
    private EntregadorApplication entregadorApplication;


    public EntregadorFacade(EntregadorApplication entregadorApplication) {
        this.entregadorApplication = entregadorApplication;
    }
    
    public List<Entregador> buscarTodos() {
        return this.entregadorApplication.buscarTodos();
    }

    
    public Entregador buscarPorId(int id) {
        return this.entregadorApplication.buscarPorId(id);
    }

    
    public Entregador gravar(Entregador Entregador) {
        return this.entregadorApplication.gravar(Entregador);
    }

    
    public Entregador atualizar(int id, Entregador Entregador) {
        return this.entregadorApplication.atualizar(id, Entregador);
    }

    
    public void excluir(int id) {
        this.entregadorApplication.excluir(id);
    }


   
}

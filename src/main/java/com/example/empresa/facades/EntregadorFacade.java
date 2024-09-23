package com.example.empresa.facades;

import com.example.empresa.applications.EntregadorApplication;
import com.example.empresa.entities.Entregador;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EntregadorFacade {
    private EntregadorApplication entregadorApplication;


    public EntregadorFacade(EntregadorApplication entregadorApplication) {
        this.entregadorApplication = entregadorApplication;
    }
    
    public List<Entregador> findAll() {
        return this.entregadorApplication.findAll();
    }

    
    public Entregador findById(int id) {
        return this.entregadorApplication.findById(id);
    }

    
    public Entregador save(Entregador Entregador) {
        return this.entregadorApplication.save(Entregador);
    }

    
    public Entregador update(int id, Entregador Entregador) {
        return this.entregadorApplication.update(id, Entregador);
    }

    
    public void deleteById(int id) {
        this.entregadorApplication.deleteById(id);
    }


   
}

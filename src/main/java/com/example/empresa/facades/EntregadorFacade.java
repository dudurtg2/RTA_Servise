package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.EntregadorApplication;
import com.example.empresa.entities.Entregador;

@Component
public class EntregadorFacade {

    private EntregadorApplication entregadorApplication;

    public EntregadorFacade(EntregadorApplication entregadorApplication) {
        this.entregadorApplication = entregadorApplication;
    }

    public List<Entregador> findAll() {
        return this.entregadorApplication.findAll();
    }

    public Entregador findById(long id) {
        return this.entregadorApplication.findById(id);
    }

    public Entregador save(Entregador entregador) {
        return this.entregadorApplication.save(entregador);
    }

    public Entregador update(long id, Entregador entregador) {
        return this.entregadorApplication.update(id, entregador);
    }

    public void deleteById(long id) {
        this.entregadorApplication.deleteById(id);
    }
}


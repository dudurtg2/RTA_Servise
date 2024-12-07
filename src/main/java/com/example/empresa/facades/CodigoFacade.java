package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.CodigoApplication;
import com.example.empresa.entities.Codigo;

@Component
public class CodigoFacade {

    private CodigoApplication codigoApplication;

    public CodigoFacade(CodigoApplication codigoApplication) {
        this.codigoApplication = codigoApplication;
    }

    public List<Codigo> findAll() {
        return this.codigoApplication.findAll();
    }

    public Codigo findById(long id) {
        return this.codigoApplication.findById(id);
    }

    public Codigo save(Codigo codigo) {
        return this.codigoApplication.save(codigo);
    }

    public Codigo update(long id, Codigo codigo) {
        return this.codigoApplication.update(id, codigo);
    }

    public void deleteById(long id) {
        this.codigoApplication.deleteById(id);
    }

    public List<Codigo> findByEntregadorId(long entregador) {
        return this.codigoApplication.findByEntregadorId(entregador);
    }
}


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

    
    public Codigo findById(int id) {
        return this.codigoApplication.findById(id);
    }

    
    public Codigo save(Codigo codigo) {
        return this.codigoApplication.save(codigo);
    }

    
    public Codigo update(int id, Codigo codigo) {
        return this.codigoApplication.update(id, codigo);
    }

    
    public void deleteById(int id) {
        this.codigoApplication.deleteById(id);
    }


   
}

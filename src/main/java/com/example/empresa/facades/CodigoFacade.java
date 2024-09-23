package com.example.empresa.facades;

import com.example.empresa.applications.CodigoApplication;
import com.example.empresa.entities.Codigo;

import java.util.List;

import org.springframework.stereotype.Component;

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

    
    public Codigo save(Codigo Codigo) {
        return this.codigoApplication.save(Codigo);
    }

    
    public Codigo update(int id, Codigo Codigo) {
        return this.codigoApplication.update(id, Codigo);
    }

    
    public void deleteById(int id) {
        this.codigoApplication.deleteById(id);
    }


   
}

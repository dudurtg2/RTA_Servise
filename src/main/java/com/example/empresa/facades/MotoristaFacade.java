package com.example.empresa.facades;

import com.example.empresa.applications.MotoristaApplication;
import com.example.empresa.entities.Motorista;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MotoristaFacade {
    private MotoristaApplication motoristaApplication;
    
    public MotoristaFacade(MotoristaApplication motoristaApplication) {
        this.motoristaApplication = motoristaApplication;
    }
    
    public List<Motorista> findAll() {
        return this.motoristaApplication.findAll();
    }

    
    public Motorista findById(int id) {
        return this.motoristaApplication.findById(id);
    }

    
    public Motorista save(Motorista Motorista) {
        return this.motoristaApplication.save(Motorista);
    }

    
    public Motorista update(int id, Motorista Motorista) {
        return this.motoristaApplication.update(id, Motorista);
    }

    
    public void deleteById(int id) {
        this.motoristaApplication.deleteById(id);
    }


   
}

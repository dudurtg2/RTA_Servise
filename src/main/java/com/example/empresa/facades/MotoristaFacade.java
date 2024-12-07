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

    public Motorista findById(long id) {
        return this.motoristaApplication.findById(id);
    }

    public Motorista save(Motorista motorista) {
        return this.motoristaApplication.save(motorista);
    }

    public Motorista update(long id, Motorista motorista) {
        return this.motoristaApplication.update(id, motorista);
    }

    public void deleteById(long id) {
        this.motoristaApplication.deleteById(id);
    }
    
}


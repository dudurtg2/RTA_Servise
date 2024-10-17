package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Motorista;
import com.example.empresa.interfaces.IMotoristaRepository;

@Component
public class MotoristaApplication {
    private IMotoristaRepository motoristaRepository;
    
    public MotoristaApplication(IMotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }
    
    public List<Motorista> findAll() {
        return this.motoristaRepository.findAll();
    }

    
    public Motorista findById(int id) {
        return this.motoristaRepository.findById(id);
    }

    
    public Motorista save(Motorista motorista) {

        return this.motoristaRepository.save(motorista);
    }

    
    public Motorista update(int id, Motorista motorista) {
        Motorista motoristaInDb = this.motoristaRepository.findById(id);

        if (motoristaInDb == null) {
            return null;
        }

        return this.motoristaRepository.update(id, motorista);
    }

    
    public void deleteById(int id) {
        this.motoristaRepository.deleteById(id);
    }


   
}

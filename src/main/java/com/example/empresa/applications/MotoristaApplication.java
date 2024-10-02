package com.example.empresa.applications;

import com.example.empresa.entities.Motorista;
import com.example.empresa.interfaces.IMotoristaRepository;

import java.util.List;

import org.springframework.stereotype.Component;

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

    
    public Motorista save(Motorista Motorista) {
        return this.motoristaRepository.save(Motorista);
    }

    
    public Motorista update(int id, Motorista Motorista) {
        Motorista motoristaInDb = this.motoristaRepository.findById(id);

        if (motoristaInDb == null) {
            return null;
        }

        return this.motoristaRepository.update(id, Motorista);
    }

    
    public void deleteById(int id) {
        this.motoristaRepository.deleteById(id);
    }


   
}

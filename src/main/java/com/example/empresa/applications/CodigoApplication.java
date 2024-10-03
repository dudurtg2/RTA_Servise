package com.example.empresa.applications;

import com.example.empresa.entities.Codigo;
import com.example.empresa.interfaces.ICodigoRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CodigoApplication {
    
    private ICodigoRepository codigoRepository;

    public CodigoApplication(ICodigoRepository codigoRepository) {
        this.codigoRepository = codigoRepository;
    }

    
    public List<Codigo> findAll() {
        return this.codigoRepository.findAll();
    }

    
    public Codigo findById(int id) {
        return this.codigoRepository.findById(id);
    }

    
    public Codigo save(Codigo Codigo) {
        return this.codigoRepository.save(Codigo);
    }

    
    public Codigo update(int id, Codigo Codigo) {
        Codigo codigoInDb = this.codigoRepository.findById(id);

        if (codigoInDb == null) {
            return null;
        }
        return this.codigoRepository.update(id, Codigo);
    }

    
    public void deleteById(int id) {
        this.codigoRepository.deleteById(id);
    }


   
}

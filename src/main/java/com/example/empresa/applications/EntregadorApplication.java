package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Entregador;
import com.example.empresa.interfaces.IEntregadorRepository;

@Component
public class EntregadorApplication {
    private IEntregadorRepository entregadorRepository;


    public EntregadorApplication(IEntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }
    
    public List<Entregador> findAll() {
        return this.entregadorRepository.findAll();
    }

    
    public Entregador findById(int id) {
        return this.entregadorRepository.findById(id);
    }

    
    public Entregador save(Entregador entregador ) {
        entregador.setEmail(entregador.getEmail().toLowerCase());
        return this.entregadorRepository.save(entregador);
    }

    
    public Entregador update(int id, Entregador entregador ) {
        Entregador entregadorInDb = this.entregadorRepository.findById(id);
        
        if (entregadorInDb == null) {
            return null;
        }
        
        entregador.setEmail(entregador.getEmail().toLowerCase());

        return this.entregadorRepository.update(id, entregador);
    }

    
    public void deleteById(int id) {
        this.entregadorRepository.deleteById(id);
    }


   
}

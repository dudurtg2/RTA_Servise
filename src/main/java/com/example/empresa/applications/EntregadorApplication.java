package com.example.empresa.applications;

import com.example.empresa.entities.Entregador;
import com.example.empresa.interfaces.IEntregadorRepository;

import java.util.List;

import org.springframework.stereotype.Component;

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

    
    public Entregador save(Entregador Entregador) {
        return this.entregadorRepository.save(Entregador);
    }

    
    public Entregador update(int id, Entregador Entregador) {
        return this.entregadorRepository.update(id, Entregador);
    }

    
    public void deleteById(int id) {
        this.entregadorRepository.deleteById(id);
    }


   
}

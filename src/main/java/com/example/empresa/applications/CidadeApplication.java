package com.example.empresa.applications;

import com.example.empresa.entities.Cidade;
import com.example.empresa.interfaces.ICidadeRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CidadeApplication {
    private ICidadeRepository cidadeRepository;

    public CidadeApplication(ICidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }
    
    public List<Cidade> findAll() {
        return this.cidadeRepository.findAll();
    }

    
    public Cidade findById(int id) {
        return this.cidadeRepository.findById(id);
    }

    
    public Cidade save(Cidade Cidade) {
        return this.cidadeRepository.save(Cidade);
    }

    
    public Cidade update(int id, Cidade Cidade) {
        return this.cidadeRepository.update(id, Cidade);
    }

    
    public void deleteById(int id) {
        this.cidadeRepository.deleteById(id);
    }


   
}

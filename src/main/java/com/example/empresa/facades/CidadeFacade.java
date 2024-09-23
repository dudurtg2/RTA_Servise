package com.example.empresa.facades;

import com.example.empresa.applications.CidadeApplication;
import com.example.empresa.entities.Cidade;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CidadeFacade {
    private CidadeApplication cidadeApplication;

    public CidadeFacade(CidadeApplication cidadeApplication) {
        this.cidadeApplication = cidadeApplication;
    }
    
    public List<Cidade> findAll() {
        return this.cidadeApplication.findAll();
    }

    
    public Cidade findById(int id) {
        return this.cidadeApplication.findById(id);
    }

    
    public Cidade save(Cidade Cidade) {
        return this.cidadeApplication.save(Cidade);
    }

    
    public Cidade update(int id, Cidade Cidade) {
        return this.cidadeApplication.update(id, Cidade);
    }

    
    public void deleteById(int id) {
        this.cidadeApplication.deleteById(id);
    }


   
}

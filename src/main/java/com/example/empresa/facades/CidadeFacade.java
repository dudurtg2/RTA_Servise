package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.CidadeApplication;
import com.example.empresa.entities.Cidade;

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

    
    public Cidade save(Cidade cidade) {
        return this.cidadeApplication.save(cidade);
    }

    
    public Cidade update(int id, Cidade cidade) {
        return this.cidadeApplication.update(id, cidade);
    }

    
    public void deleteById(int id) {
        this.cidadeApplication.deleteById(id);
    }


   
}

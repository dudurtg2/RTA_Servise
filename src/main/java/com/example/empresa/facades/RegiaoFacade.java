package com.example.empresa.facades;

import com.example.empresa.applications.RegiaoApplication;
import com.example.empresa.entities.Regiao;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RegiaoFacade {
    private RegiaoApplication regiaoApplication;

    public RegiaoFacade(RegiaoApplication regiaoApplication) {
        this.regiaoApplication = regiaoApplication;
    }
    
    public List<Regiao> findAll() {
        return this.regiaoApplication.findAll();
    }

    
    public Regiao findById(int id) {
        return this.regiaoApplication.findById(id);
    }

    
    public Regiao save(Regiao Regiao) {
        return this.regiaoApplication.save(Regiao);
    }

    
    public Regiao update(int id, Regiao Regiao) {
        return this.regiaoApplication.update(id, Regiao);
    }

    
    public void deleteById(int id) {
        this.regiaoApplication.deleteById(id);
    }


   
}

package com.example.empresa.facades;

import com.example.empresa.applications.HistoricoApplication;
import com.example.empresa.entities.Historico;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HistoricoFacade {
    private HistoricoApplication historicoApplication;


    public HistoricoFacade(HistoricoApplication historicoApplication) {
        this.historicoApplication = historicoApplication;
    }
    
    public List<Historico> findAll() {
        return this.historicoApplication.findAll();
    }

    
    public Historico findById(int id) {
        return this.historicoApplication.findById(id);
    }

    
    public Historico save(Historico Historico) {
        return this.historicoApplication.save(Historico);
    }

    
    public Historico update(int id, Historico Historico) {
        return this.historicoApplication.update(id, Historico);
    }

    
    public void deleteById(int id) {
        this.historicoApplication.deleteById(id);
    }


   
}

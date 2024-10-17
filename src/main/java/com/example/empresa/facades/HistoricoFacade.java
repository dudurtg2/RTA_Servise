package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.HistoricoApplication;
import com.example.empresa.entities.Historico;

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

    
    public Historico save(Historico historico) {
        return this.historicoApplication.save(historico);
    }

    
    public Historico update(int id, Historico historico) {
        return this.historicoApplication.update(id, historico);
    }

    
    public void deleteById(int id) {
        this.historicoApplication.deleteById(id);
    }


   
}

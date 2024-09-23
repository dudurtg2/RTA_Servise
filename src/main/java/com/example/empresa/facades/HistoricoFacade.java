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
    
    public List<Historico> buscarTodos() {
        return this.historicoApplication.buscarTodos();
    }

    
    public Historico buscarPorId(int id) {
        return this.historicoApplication.buscarPorId(id);
    }

    
    public Historico gravar(Historico Historico) {
        return this.historicoApplication.gravar(Historico);
    }

    
    public Historico atualizar(int id, Historico Historico) {
        return this.historicoApplication.atualizar(id, Historico);
    }

    
    public void excluir(int id) {
        this.historicoApplication.excluir(id);
    }


   
}

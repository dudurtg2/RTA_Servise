package com.example.empresa.facades;

import com.example.empresa.applications.HistoricoApplication;
import com.example.empresa.entities.Historico;

import java.util.List;


public class HistoricoFacade {
    HistoricoApplication HistoricoApplication = new HistoricoApplication();
    
    public List<Historico> buscarTodos() {
        return this.HistoricoApplication.buscarTodos();
    }

    
    public Historico buscarPorId(int id) {
        return this.HistoricoApplication.buscarPorId(id);
    }

    
    public Historico gravar(Historico Historico) {
        return this.HistoricoApplication.gravar(Historico);
    }

    
    public Historico atualizar(int id, Historico Historico) {
        return this.HistoricoApplication.atualizar(id, Historico);
    }

    
    public void excluir(int id) {
        this.HistoricoApplication.excluir(id);
    }


   
}

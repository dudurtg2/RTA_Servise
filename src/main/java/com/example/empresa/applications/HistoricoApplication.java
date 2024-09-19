package com.example.empresa.applications;

import com.example.empresa.repositories.HistoricoRepository;
import com.example.empresa.entities.Historico;

import java.util.List;


public class HistoricoApplication {
    HistoricoRepository HistoricoRepository = new HistoricoRepository();
    
    public List<Historico> buscarTodos() {
        return this.HistoricoRepository.buscarTodos();
    }

    
    public Historico buscarPorId(int id) {
        return this.HistoricoRepository.buscarPorId(id);
    }

    
    public Historico gravar(Historico Historico) {
        return this.HistoricoRepository.gravar(Historico);
    }

    
    public Historico atualizar(int id, Historico Historico) {
        return this.HistoricoRepository.atualizar(id, Historico);
    }

    
    public void excluir(int id) {
        this.HistoricoRepository.excluir(id);
    }


   
}

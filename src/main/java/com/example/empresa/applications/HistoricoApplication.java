package com.example.empresa.applications;

import com.example.empresa.repositories.HistoricoRepository;
import com.example.empresa.entities.Historico;

import java.util.List;


public class HistoricoApplication {
    private HistoricoRepository historicoRepository;


    public HistoricoApplication(HistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }
    
    public List<Historico> buscarTodos() {
        return this.historicoRepository.buscarTodos();
    }

    
    public Historico buscarPorId(int id) {
        return this.historicoRepository.buscarPorId(id);
    }

    
    public Historico gravar(Historico Historico) {
        return this.historicoRepository.gravar(Historico);
    }

    
    public Historico atualizar(int id, Historico Historico) {
        return this.historicoRepository.atualizar(id, Historico);
    }

    
    public void excluir(int id) {
        this.historicoRepository.excluir(id);
    }


   
}

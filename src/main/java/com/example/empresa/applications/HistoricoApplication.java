package com.example.empresa.applications;

import com.example.empresa.entities.Historico;
import com.example.empresa.interfaces.IHistoricoRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HistoricoApplication {
    private IHistoricoRepository historicoRepository;


    public HistoricoApplication(IHistoricoRepository historicoRepository) {
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

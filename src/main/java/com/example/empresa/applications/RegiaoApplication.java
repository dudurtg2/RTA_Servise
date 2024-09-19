package com.example.empresa.applications;

import com.example.empresa.repositories.RegiaoRepository;
import com.example.empresa.entities.Regiao;

import java.util.List;


public class RegiaoApplication {
    private RegiaoRepository regiaoRepository;

    public RegiaoApplication(RegiaoRepository regiaoRepository) {
        this.regiaoRepository = regiaoRepository;
    }
    
    public List<Regiao> buscarTodos() {
        return this.regiaoRepository.buscarTodos();
    }

    
    public Regiao buscarPorId(int id) {
        return this.regiaoRepository.buscarPorId(id);
    }

    
    public Regiao gravar(Regiao Regiao) {
        return this.regiaoRepository.gravar(Regiao);
    }

    
    public Regiao atualizar(int id, Regiao Regiao) {
        return this.regiaoRepository.atualizar(id, Regiao);
    }

    
    public void excluir(int id) {
        this.regiaoRepository.excluir(id);
    }


   
}

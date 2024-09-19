package com.example.empresa.applications;

import com.example.empresa.repositories.RegiaoRepository;
import com.example.empresa.entities.Regiao;

import java.util.List;


public class RegiaoApplication {
    RegiaoRepository RegiaoRepository = new RegiaoRepository();
    
    public List<Regiao> buscarTodos() {
        return this.RegiaoRepository.buscarTodos();
    }

    
    public Regiao buscarPorId(int id) {
        return this.RegiaoRepository.buscarPorId(id);
    }

    
    public Regiao gravar(Regiao Regiao) {
        return this.RegiaoRepository.gravar(Regiao);
    }

    
    public Regiao atualizar(int id, Regiao Regiao) {
        return this.RegiaoRepository.atualizar(id, Regiao);
    }

    
    public void excluir(int id) {
        this.RegiaoRepository.excluir(id);
    }


   
}

package com.example.empresa.applications;


import com.example.empresa.entities.Regiao;
import com.example.empresa.interfaces.IRegiaoRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RegiaoApplication {
    private IRegiaoRepository regiaoRepository;

    public RegiaoApplication(IRegiaoRepository regiaoRepository) {
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

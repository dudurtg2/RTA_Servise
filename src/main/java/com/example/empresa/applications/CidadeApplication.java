package com.example.empresa.applications;

import com.example.empresa.repositories.CidadeRepository;
import com.example.empresa.entities.Cidade;

import java.util.List;


public class CidadeApplication {
    CidadeRepository CidadeRepository = new CidadeRepository();
    
    public List<Cidade> buscarTodos() {
        return this.CidadeRepository.buscarTodos();
    }

    
    public Cidade buscarPorId(int id) {
        return this.CidadeRepository.buscarPorId(id);
    }

    
    public Cidade gravar(Cidade Cidade) {
        return this.CidadeRepository.gravar(Cidade);
    }

    
    public Cidade atualizar(int id, Cidade Cidade) {
        return this.CidadeRepository.atualizar(id, Cidade);
    }

    
    public void excluir(int id) {
        this.CidadeRepository.excluir(id);
    }


   
}

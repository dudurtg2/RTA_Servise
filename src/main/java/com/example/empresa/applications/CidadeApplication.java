package com.example.empresa.applications;

import com.example.empresa.repositories.CidadeRepository;
import com.example.empresa.entities.Cidade;

import java.util.List;


public class CidadeApplication {
    private CidadeRepository cidadeRepository;

    public CidadeApplication(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }
    
    public List<Cidade> buscarTodos() {
        return this.cidadeRepository.buscarTodos();
    }

    
    public Cidade buscarPorId(int id) {
        return this.cidadeRepository.buscarPorId(id);
    }

    
    public Cidade gravar(Cidade Cidade) {
        return this.cidadeRepository.gravar(Cidade);
    }

    
    public Cidade atualizar(int id, Cidade Cidade) {
        return this.cidadeRepository.atualizar(id, Cidade);
    }

    
    public void excluir(int id) {
        this.cidadeRepository.excluir(id);
    }


   
}

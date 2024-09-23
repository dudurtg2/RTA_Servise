package com.example.empresa.applications;

import com.example.empresa.entities.Cidade;
import com.example.empresa.interfaces.ICidadeRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CidadeApplication {
    private ICidadeRepository cidadeRepository;

    public CidadeApplication(ICidadeRepository cidadeRepository) {
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

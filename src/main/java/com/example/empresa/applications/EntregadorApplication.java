package com.example.empresa.applications;

import com.example.empresa.repositories.EntregadorRepository;
import com.example.empresa.entities.Entregador;

import java.util.List;


public class EntregadorApplication {
    private EntregadorRepository entregadorRepository;


    public EntregadorApplication(EntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
    }
    
    public List<Entregador> buscarTodos() {
        return this.entregadorRepository.buscarTodos();
    }

    
    public Entregador buscarPorId(int id) {
        return this.entregadorRepository.buscarPorId(id);
    }

    
    public Entregador gravar(Entregador Entregador) {
        return this.entregadorRepository.gravar(Entregador);
    }

    
    public Entregador atualizar(int id, Entregador Entregador) {
        return this.entregadorRepository.atualizar(id, Entregador);
    }

    
    public void excluir(int id) {
        this.entregadorRepository.excluir(id);
    }


   
}

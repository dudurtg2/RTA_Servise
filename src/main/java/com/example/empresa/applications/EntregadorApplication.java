package com.example.empresa.applications;

import com.example.empresa.repositories.EntregadorRepository;
import com.example.empresa.entities.Entregador;

import java.util.List;


public class EntregadorApplication {
    EntregadorRepository EntregadorRepository = new EntregadorRepository();
    
    public List<Entregador> buscarTodos() {
        return this.EntregadorRepository.buscarTodos();
    }

    
    public Entregador buscarPorId(int id) {
        return this.EntregadorRepository.buscarPorId(id);
    }

    
    public Entregador gravar(Entregador Entregador) {
        return this.EntregadorRepository.gravar(Entregador);
    }

    
    public Entregador atualizar(int id, Entregador Entregador) {
        return this.EntregadorRepository.atualizar(id, Entregador);
    }

    
    public void excluir(int id) {
        this.EntregadorRepository.excluir(id);
    }


   
}

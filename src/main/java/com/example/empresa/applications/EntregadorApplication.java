package com.example.empresa.applications;

import com.example.empresa.entities.Entregador;
import com.example.empresa.interfaces.IEntregadorRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EntregadorApplication {
    private IEntregadorRepository entregadorRepository;


    public EntregadorApplication(IEntregadorRepository entregadorRepository) {
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

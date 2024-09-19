package com.example.empresa.applications;

import com.example.empresa.repositories.MotoristaRepository;
import com.example.empresa.entities.Motorista;

import java.util.List;


public class MotoristaApplication {
    private MotoristaRepository motoristaRepository;
    
    public MotoristaApplication(MotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }
    
    public List<Motorista> buscarTodos() {
        return this.motoristaRepository.buscarTodos();
    }

    
    public Motorista buscarPorId(int id) {
        return this.motoristaRepository.buscarPorId(id);
    }

    
    public Motorista gravar(Motorista Motorista) {
        return this.motoristaRepository.gravar(Motorista);
    }

    
    public Motorista atualizar(int id, Motorista Motorista) {
        return this.motoristaRepository.atualizar(id, Motorista);
    }

    
    public void excluir(int id) {
        this.motoristaRepository.excluir(id);
    }


   
}

package com.example.empresa.applications;

import com.example.empresa.repositories.MotoristaRepository;
import com.example.empresa.entities.Motorista;

import java.util.List;


public class MotoristaApplication {
    MotoristaRepository MotoristaRepository = new MotoristaRepository();
    
    public List<Motorista> buscarTodos() {
        return this.MotoristaRepository.buscarTodos();
    }

    
    public Motorista buscarPorId(int id) {
        return this.MotoristaRepository.buscarPorId(id);
    }

    
    public Motorista gravar(Motorista Motorista) {
        return this.MotoristaRepository.gravar(Motorista);
    }

    
    public Motorista atualizar(int id, Motorista Motorista) {
        return this.MotoristaRepository.atualizar(id, Motorista);
    }

    
    public void excluir(int id) {
        this.MotoristaRepository.excluir(id);
    }


   
}

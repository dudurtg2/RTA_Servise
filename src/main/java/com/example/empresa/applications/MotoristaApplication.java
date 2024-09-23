package com.example.empresa.applications;

import com.example.empresa.entities.Motorista;
import com.example.empresa.interfaces.IMotoristaRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class MotoristaApplication {
    private IMotoristaRepository motoristaRepository;
    
    public MotoristaApplication(IMotoristaRepository motoristaRepository) {
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

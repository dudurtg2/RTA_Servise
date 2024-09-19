package com.example.empresa.facades;

import com.example.empresa.applications.MotoristaApplication;
import com.example.empresa.entities.Motorista;

import java.util.List;


public class MotoristaFacade {
    private MotoristaApplication motoristaApplication;
    
    public MotoristaFacade(MotoristaApplication motoristaApplication) {
        this.motoristaApplication = motoristaApplication;
    }
    
    public List<Motorista> buscarTodos() {
        return this.motoristaApplication.buscarTodos();
    }

    
    public Motorista buscarPorId(int id) {
        return this.motoristaApplication.buscarPorId(id);
    }

    
    public Motorista gravar(Motorista Motorista) {
        return this.motoristaApplication.gravar(Motorista);
    }

    
    public Motorista atualizar(int id, Motorista Motorista) {
        return this.motoristaApplication.atualizar(id, Motorista);
    }

    
    public void excluir(int id) {
        this.motoristaApplication.excluir(id);
    }


   
}

package com.example.empresa.facades;

import com.example.empresa.applications.MotoristaApplication;
import com.example.empresa.entities.Motorista;

import java.util.List;


public class MotoristaFacade {
    MotoristaApplication MotoristaApplication = new MotoristaApplication();
    
    public List<Motorista> buscarTodos() {
        return this.MotoristaApplication.buscarTodos();
    }

    
    public Motorista buscarPorId(int id) {
        return this.MotoristaApplication.buscarPorId(id);
    }

    
    public Motorista gravar(Motorista Motorista) {
        return this.MotoristaApplication.gravar(Motorista);
    }

    
    public Motorista atualizar(int id, Motorista Motorista) {
        return this.MotoristaApplication.atualizar(id, Motorista);
    }

    
    public void excluir(int id) {
        this.MotoristaApplication.excluir(id);
    }


   
}

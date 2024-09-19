package com.example.empresa.applications;

import com.example.empresa.repositories.CodigoRepository;
import com.example.empresa.entities.Codigo;

import java.util.List;


public class CodigoApplication {
    CodigoRepository CodigoRepository = new CodigoRepository();
    
    public List<Codigo> buscarTodos() {
        return this.CodigoRepository.buscarTodos();
    }

    
    public Codigo buscarPorId(int id) {
        return this.CodigoRepository.buscarPorId(id);
    }

    
    public Codigo gravar(Codigo Codigo) {
        return this.CodigoRepository.gravar(Codigo);
    }

    
    public Codigo atualizar(int id, Codigo Codigo) {
        return this.CodigoRepository.atualizar(id, Codigo);
    }

    
    public void excluir(int id) {
        this.CodigoRepository.excluir(id);
    }


   
}

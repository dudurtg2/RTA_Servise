package com.example.empresa.applications;

import com.example.empresa.repositories.CodigoRepository;
import com.example.empresa.entities.Codigo;

import java.util.List;


public class CodigoApplication {
    private CodigoRepository codigoRepository;

    public CodigoApplication(CodigoRepository codigoRepository) {
        this.codigoRepository = codigoRepository;
    }

    
    public List<Codigo> buscarTodos() {
        return this.codigoRepository.buscarTodos();
    }

    
    public Codigo buscarPorId(int id) {
        return this.codigoRepository.buscarPorId(id);
    }

    
    public Codigo gravar(Codigo Codigo) {
        return this.codigoRepository.gravar(Codigo);
    }

    
    public Codigo atualizar(int id, Codigo Codigo) {
        return this.codigoRepository.atualizar(id, Codigo);
    }

    
    public void excluir(int id) {
        this.codigoRepository.excluir(id);
    }


   
}

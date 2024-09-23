package com.example.empresa.applications;

import com.example.empresa.entities.Codigo;
import com.example.empresa.interfaces.ICodigoRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CodigoApplication {
    
    private ICodigoRepository codigoRepository;

    public CodigoApplication(ICodigoRepository codigoRepository) {
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

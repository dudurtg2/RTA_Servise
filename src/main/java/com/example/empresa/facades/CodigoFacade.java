package com.example.empresa.facades;

import com.example.empresa.applications.CodigoApplication;
import com.example.empresa.entities.Codigo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CodigoFacade {
    private CodigoApplication codigoApplication;

    public CodigoFacade(CodigoApplication codigoApplication) {
        this.codigoApplication = codigoApplication;
    }

    
    public List<Codigo> buscarTodos() {
        return this.codigoApplication.buscarTodos();
    }

    
    public Codigo buscarPorId(int id) {
        return this.codigoApplication.buscarPorId(id);
    }

    
    public Codigo gravar(Codigo Codigo) {
        return this.codigoApplication.gravar(Codigo);
    }

    
    public Codigo atualizar(int id, Codigo Codigo) {
        return this.codigoApplication.atualizar(id, Codigo);
    }

    
    public void excluir(int id) {
        this.codigoApplication.excluir(id);
    }


   
}

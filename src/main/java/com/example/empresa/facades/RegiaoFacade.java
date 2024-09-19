package com.example.empresa.facades;

import com.example.empresa.applications.RegiaoApplication;
import com.example.empresa.entities.Regiao;

import java.util.List;


public class RegiaoFacade {
    private RegiaoApplication regiaoApplication;

    public RegiaoFacade(RegiaoApplication regiaoApplication) {
        this.regiaoApplication = regiaoApplication;
    }
    
    public List<Regiao> buscarTodos() {
        return this.regiaoApplication.buscarTodos();
    }

    
    public Regiao buscarPorId(int id) {
        return this.regiaoApplication.buscarPorId(id);
    }

    
    public Regiao gravar(Regiao Regiao) {
        return this.regiaoApplication.gravar(Regiao);
    }

    
    public Regiao atualizar(int id, Regiao Regiao) {
        return this.regiaoApplication.atualizar(id, Regiao);
    }

    
    public void excluir(int id) {
        this.regiaoApplication.excluir(id);
    }


   
}

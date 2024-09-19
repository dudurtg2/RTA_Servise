package com.example.empresa.facades;

import com.example.empresa.applications.RegiaoApplication;
import com.example.empresa.entities.Regiao;

import java.util.List;


public class RegiaoFacade {
    RegiaoApplication RegiaoApplication = new RegiaoApplication();
    
    public List<Regiao> buscarTodos() {
        return this.RegiaoApplication.buscarTodos();
    }

    
    public Regiao buscarPorId(int id) {
        return this.RegiaoApplication.buscarPorId(id);
    }

    
    public Regiao gravar(Regiao Regiao) {
        return this.RegiaoApplication.gravar(Regiao);
    }

    
    public Regiao atualizar(int id, Regiao Regiao) {
        return this.RegiaoApplication.atualizar(id, Regiao);
    }

    
    public void excluir(int id) {
        this.RegiaoApplication.excluir(id);
    }


   
}

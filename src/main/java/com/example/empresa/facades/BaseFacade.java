package com.example.empresa.facades;

import com.example.empresa.applications.BaseApplication;
import com.example.empresa.entities.Base;

import java.util.List;


public class BaseFacade {
    private BaseApplication baseApplication;

    public BaseFacade(BaseApplication baseApplication) {
        this.baseApplication = baseApplication;
    }
    
    
    public List<Base> buscarTodos() {
        return this.baseApplication.buscarTodos();
    }

    
    public Base buscarPorId(int id) {
        return this.baseApplication.buscarPorId(id);
    }

    
    public Base gravar(Base base) {
        return this.baseApplication.gravar(base);
    }

    
    public Base atualizar(int id, Base base) {
        return this.baseApplication.atualizar(id, base);
    }

    
    public void excluir(int id) {
        this.baseApplication.excluir(id);
    }


   
}

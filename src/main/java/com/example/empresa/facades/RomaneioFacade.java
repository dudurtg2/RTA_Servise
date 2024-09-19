package com.example.empresa.facades;

import com.example.empresa.applications.RomaneioApplication;
import com.example.empresa.entities.Romaneio;

import java.util.List;


public class RomaneioFacade {
    RomaneioApplication RomaneioApplication = new RomaneioApplication();
    
    public List<Romaneio> buscarTodos() {
        return this.RomaneioApplication.buscarTodos();
    }

    
    public Romaneio buscarPorId(int id) {
        return this.RomaneioApplication.buscarPorId(id);
    }

    
    public Romaneio gravar(Romaneio Romaneio) {
        return this.RomaneioApplication.gravar(Romaneio);
    }

    
    public Romaneio atualizar(int id, Romaneio Romaneio) {
        return this.RomaneioApplication.atualizar(id, Romaneio);
    }

    
    public void excluir(int id) {
        this.RomaneioApplication.excluir(id);
    }


   
}

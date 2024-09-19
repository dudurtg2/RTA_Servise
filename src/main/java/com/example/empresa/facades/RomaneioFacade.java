package com.example.empresa.facades;

import com.example.empresa.applications.RomaneioApplication;
import com.example.empresa.entities.Romaneio;

import java.util.List;


public class RomaneioFacade {
    RomaneioApplication romaneioApplication;
    public RomaneioFacade(RomaneioApplication romaneioApplication) {
        this.romaneioApplication = romaneioApplication;
    }
    
    public List<Romaneio> buscarTodos() {
        return this.romaneioApplication.buscarTodos();
    }

    
    public Romaneio buscarPorId(int id) {
        return this.romaneioApplication.buscarPorId(id);
    }

    
    public Romaneio gravar(Romaneio Romaneio) {
        return this.romaneioApplication.gravar(Romaneio);
    }

    
    public Romaneio atualizar(int id, Romaneio Romaneio) {
        return this.romaneioApplication.atualizar(id, Romaneio);
    }

    
    public void excluir(int id) {
        this.romaneioApplication.excluir(id);
    }


   
}

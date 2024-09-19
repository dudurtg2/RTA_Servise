package com.example.empresa.applications;

import com.example.empresa.repositories.RomaneioRepository;
import com.example.empresa.entities.Romaneio;

import java.util.List;


public class RomaneioApplication {
    RomaneioRepository RomaneioRepository = new RomaneioRepository();
    
    public List<Romaneio> buscarTodos() {
        return this.RomaneioRepository.buscarTodos();
    }

    
    public Romaneio buscarPorId(int id) {
        return this.RomaneioRepository.buscarPorId(id);
    }

    
    public Romaneio gravar(Romaneio Romaneio) {
        return this.RomaneioRepository.gravar(Romaneio);
    }

    
    public Romaneio atualizar(int id, Romaneio Romaneio) {
        return this.RomaneioRepository.atualizar(id, Romaneio);
    }

    
    public void excluir(int id) {
        this.RomaneioRepository.excluir(id);
    }


   
}

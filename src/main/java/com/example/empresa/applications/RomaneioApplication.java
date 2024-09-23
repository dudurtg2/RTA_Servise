package com.example.empresa.applications;

import com.example.empresa.entities.Romaneio;
import com.example.empresa.interfaces.IRomanioRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class RomaneioApplication {
    private IRomanioRepository romaneioRepository;
    
    public RomaneioApplication(IRomanioRepository romaneioRepository) {
        this.romaneioRepository = romaneioRepository;
    }
    
    public List<Romaneio> buscarTodos() {
        return this.romaneioRepository.buscarTodos();
    }

    
    public Romaneio buscarPorId(int id) {
        return this.romaneioRepository.buscarPorId(id);
    }

    
    public Romaneio gravar(Romaneio Romaneio) {
        return this.romaneioRepository.gravar(Romaneio);
    }

    
    public Romaneio atualizar(int id, Romaneio Romaneio) {
        return this.romaneioRepository.atualizar(id, Romaneio);
    }

    
    public void excluir(int id) {
        this.romaneioRepository.excluir(id);
    }


   
}

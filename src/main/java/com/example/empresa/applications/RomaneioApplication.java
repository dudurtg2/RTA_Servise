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
    
    public List<Romaneio> findAll() {
        return this.romaneioRepository.findAll();
    }

    
    public Romaneio findById(int id) {
        return this.romaneioRepository.findById(id);
    }

    
    public Romaneio save(Romaneio Romaneio) {
        return this.romaneioRepository.save(Romaneio);
    }

    
    public Romaneio update(int id, Romaneio Romaneio) {
        Romaneio romaneioInDb = this.romaneioRepository.findById(id);

        if (romaneioInDb == null) {
            return null;
        }
        return this.romaneioRepository.update(id, Romaneio);
    }

    
    public void deleteById(int id) {
        this.romaneioRepository.deleteById(id);
    }


   
}

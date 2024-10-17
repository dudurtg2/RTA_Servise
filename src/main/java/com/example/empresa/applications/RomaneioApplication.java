package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Romaneio;
import com.example.empresa.interfaces.IRomaneioRepository;

@Component
public class RomaneioApplication {
    private IRomaneioRepository romaneioRepository;

    public RomaneioApplication(IRomaneioRepository romaneioRepository) {
        this.romaneioRepository = romaneioRepository;
    }
    
    public List<Romaneio> findAll() {
        return this.romaneioRepository.findAll();
    }

    
    public Romaneio findById(int id) {
        return this.romaneioRepository.findById(id);
    }

    
    public Romaneio save(Romaneio romaneio) {
        return this.romaneioRepository.save(romaneio);
    }

    
    public Romaneio update(int id, Romaneio romaneio) {
        Romaneio romaneioInDb = this.romaneioRepository.findById(id);

        if (romaneioInDb == null) {
            return null;
        }
        return this.romaneioRepository.update(id, romaneio);
    }

    
    public void deleteById(int id) {
        this.romaneioRepository.deleteById(id);
    }


   
}

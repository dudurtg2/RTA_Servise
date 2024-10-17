package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.RomaneioApplication;
import com.example.empresa.entities.Romaneio;

@Component
public class RomaneioFacade {
    RomaneioApplication romaneioApplication;
    public RomaneioFacade(RomaneioApplication romaneioApplication) {
        this.romaneioApplication = romaneioApplication;
    }
    
    public List<Romaneio> findAll() {
        return this.romaneioApplication.findAll();
    }

    
    public Romaneio findById(int id) {
        return this.romaneioApplication.findById(id);
    }

    
    public Romaneio save(Romaneio romaneio) {
        return this.romaneioApplication.save(romaneio);
    }

    
    public Romaneio update(int id, Romaneio romaneio) {
        return this.romaneioApplication.update(id, romaneio);
    }

    
    public void deleteById(int id) {
        this.romaneioApplication.deleteById(id);
    }


   
}

package com.example.empresa.facades;

import com.example.empresa.applications.RomaneioApplication;
import com.example.empresa.entities.Romaneio;

import java.util.List;

import org.springframework.stereotype.Component;

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

    
    public Romaneio save(Romaneio Romaneio) {
        return this.romaneioApplication.save(Romaneio);
    }

    
    public Romaneio update(int id, Romaneio Romaneio) {
        return this.romaneioApplication.update(id, Romaneio);
    }

    
    public void deleteById(int id) {
        this.romaneioApplication.deleteById(id);
    }


   
}

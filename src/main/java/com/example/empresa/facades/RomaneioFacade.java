package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.RomaneioApplication;
import com.example.empresa.controllers.records.RomaneioRecord;
import com.example.empresa.controllers.records.RomaneioUpdateRecord;
import com.example.empresa.entities.Romaneio;

@Component
public class RomaneioFacade {

    private RomaneioApplication romaneioApplication;

    public RomaneioFacade(RomaneioApplication romaneioApplication) {
        this.romaneioApplication = romaneioApplication;
    }

    public List<Romaneio> findAll() {
        return this.romaneioApplication.findAll();
    }

    public Romaneio findById(long id) {
        return this.romaneioApplication.findById(id);
    }

    public Romaneio save(RomaneioRecord romaneio) {
        return this.romaneioApplication.save(romaneio);
    }

    public Romaneio update(long id, RomaneioUpdateRecord romaneio) {
        return this.romaneioApplication.update(id, romaneio);
    }

    public Romaneio update(String codigo, RomaneioUpdateRecord romaneio) {
        return this.romaneioApplication.update(codigo, romaneio);
    }

    public void deleteById(long id) {
        this.romaneioApplication.deleteById(id);
    }

    public int getCountForStatus(String status) {
        return this.romaneioApplication.getCountForStatus(status);
    }

    public List<Romaneio> findByStatus(String sts) {
        return this.romaneioApplication.findByStatus(sts);
    }

    public List<Romaneio> findByMotorista(Long motorista) {
        return this.romaneioApplication.findByMotorista(motorista);
    }

    public List<Romaneio> findByEntregador(Long entregador) {
        return this.romaneioApplication.findByEntregador(entregador);
    }

    public Romaneio findByCodigoUid(String codigoUid) {
        return this.romaneioApplication.findByCodigoUid(codigoUid);
    }

    public Romaneio findBySearch(String seach) {
        return this.romaneioApplication.findBySearch(seach);
    }
}


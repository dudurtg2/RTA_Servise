package com.example.empresa.facades;

import java.awt.image.BufferedImage;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.RomaneioApplication;
import com.example.empresa.controllers.records.RomaneioRecord;
import com.example.empresa.controllers.records.RomaneioResponceFinalizadoRecord;
import com.example.empresa.controllers.records.RomaneioResponceRetiradoRecord;
import com.example.empresa.controllers.records.RomaneioUpdateRecord;
import com.example.empresa.controllers.records.RomaneioVencimentosRecord;
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
    public List<RomaneioResponceFinalizadoRecord> getFinishedAll() {
        return this.romaneioApplication.getFinishedAll();
    }
    
    public List<RomaneioResponceRetiradoRecord> getRetiradoAll(long id) {
        return this.romaneioApplication.getRetiradoAll(id);
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
    public RomaneioVencimentosRecord getVencimentos() {
        return this.romaneioApplication.getVencimentos();
    }
    
    public void deleteById(long id) {
        this.romaneioApplication.deleteById(id);
    }

    public int getCountForStatus(String status) {
        return this.romaneioApplication.getCountForStatus(status);
    }
    public int getCountCodigosStsAll(String status) {
        return this.romaneioApplication.getCountCodigosStsAll(status);
    }

    public List<Romaneio> findByStatus(String sts) {
        return this.romaneioApplication.findByStatus(sts);
    }

    public List<Romaneio> findByMotorista(Long motorista) {
        return this.romaneioApplication.findByMotorista(motorista);
    }
    public List<Romaneio> findByMotoristaSts(Long motorista, String sts)  {
        return this.romaneioApplication.findByMotoristaSts(motorista, sts);
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

    public Romaneio uploadImage(String codigo, BufferedImage image) {
        return this.romaneioApplication.uploadImage(codigo, image);
    }
}


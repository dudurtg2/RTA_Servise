package com.example.empresa.controllers;

import com.example.empresa.controllers.records.ResponceRecord;
import com.example.empresa.controllers.records.RomaneioRecord;
import com.example.empresa.controllers.records.RomaneioResponceFinalizadoRecord;
import com.example.empresa.controllers.records.RomaneioResponceRetiradoRecord;
import com.example.empresa.controllers.records.RomaneioUpdateRecord;
import com.example.empresa.entities.Romaneio;
import com.example.empresa.facades.RomaneioFacade;
import com.example.empresa.services.ErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import com.example.empresa.controllers.records.ImageUploadRecord;
import com.example.empresa.controllers.records.RomaneioVencimentosRecord;

@RestController
@RequestScope
@RequestMapping("/api/romaneios")
public class RomaneioController {

    private RomaneioFacade romaneioFacade;

    @Autowired
    public RomaneioController(RomaneioFacade romaneioFacade) {
        this.romaneioFacade = romaneioFacade;
    }

    @PostMapping("/imageUpload/{codigo}")
    public ResponseEntity<Romaneio> uploadImage(@RequestBody ImageUploadRecord request,
            @PathVariable String codigo) throws IOException {

        byte[] imageBytes = Base64.getDecoder().decode(request.base64Image());
        InputStream inputStream = new ByteArrayInputStream(imageBytes);
        BufferedImage image = ImageIO.read(inputStream);

        Romaneio romaneio = this.romaneioFacade.uploadImage(codigo, image);

        return new ResponseEntity<>(romaneio, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Romaneio>> findAll() {
        List<Romaneio> romaneio = this.romaneioFacade.findAll();
        return new ResponseEntity<List<Romaneio>>(romaneio, HttpStatus.OK);
    }

    @GetMapping("/getFinishedAll")
    public ResponseEntity<List<RomaneioResponceFinalizadoRecord>> getFinishedAll() {
        List<RomaneioResponceFinalizadoRecord> romaneio = this.romaneioFacade.getFinishedAll();
        return new ResponseEntity<List<RomaneioResponceFinalizadoRecord>>(romaneio, HttpStatus.OK);
    }
    @GetMapping("/getRetiradoAll/{id}")
    public ResponseEntity<List<RomaneioResponceRetiradoRecord>> getRetiradoAll(@PathVariable long id) {
        List<RomaneioResponceRetiradoRecord> romaneio = this.romaneioFacade.getRetiradoAll(id);
        return new ResponseEntity<List<RomaneioResponceRetiradoRecord>>(romaneio, HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Romaneio> findById(@PathVariable long id) {
        Romaneio romaneio = this.romaneioFacade.findById(id);
        return new ResponseEntity<Romaneio>(romaneio, HttpStatus.OK);
    }

    @GetMapping("/findBySearch/{search}")
    public ResponseEntity<Romaneio> findBySearch(@PathVariable String search) {
        Romaneio romaneio = this.romaneioFacade.findBySearch(search);
        if (romaneio == null) {
            throw new ErrorException("Romaneio não encontrado.", 404);
        }
        return new ResponseEntity<Romaneio>(romaneio, HttpStatus.OK);
    }

    @GetMapping("/count/sts/{status}")
    public ResponseEntity<ResponceRecord> getCountStsAll(@PathVariable String status) {
        return new ResponseEntity<ResponceRecord>(
                new ResponceRecord(this.romaneioFacade.getCountForStatus(status), status), HttpStatus.OK);
    }

    @GetMapping("/count/vencidos")
    public ResponseEntity<RomaneioVencimentosRecord> getCountVencidosAll() {
        return new ResponseEntity<RomaneioVencimentosRecord>(this.romaneioFacade.getVencimentos(), HttpStatus.OK);
    }

    @GetMapping("/count/codigos/sts/{status}")
    public ResponseEntity<ResponceRecord> getCountCodigosStsAll(@PathVariable String status) {
        return new ResponseEntity<ResponceRecord>(
                new ResponceRecord(this.romaneioFacade.getCountCodigosStsAll(status), status), HttpStatus.OK);
    }

    @GetMapping("/count/driver/{driver}")
    public ResponseEntity<List<Romaneio>> getCountDriver(@PathVariable long driver) {
        return new ResponseEntity<List<Romaneio>>(this.romaneioFacade.findByMotorista(driver), HttpStatus.OK);
    }

    @GetMapping("/count/driver/{driver}/{sts}")
    public ResponseEntity<List<Romaneio>> getCountDriver(@PathVariable long driver, @PathVariable String sts) {
        return new ResponseEntity<List<Romaneio>>(this.romaneioFacade.findByMotoristaSts(driver, sts), HttpStatus.OK);
    }

    @GetMapping("/count/delivery/{delivery}")
    public ResponseEntity<List<Romaneio>> getCountDelivery(@PathVariable long delivery) {
        return new ResponseEntity<List<Romaneio>>(this.romaneioFacade.findByEntregador(delivery), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Romaneio> save(@RequestBody RomaneioRecord romaneio) {
        Romaneio romaneioSaved = romaneioFacade.save(romaneio);
        return new ResponseEntity<Romaneio>(romaneioSaved, HttpStatus.CREATED);
    }

    @PutMapping("/update/id/{id}")
    public ResponseEntity<Romaneio> update(
            @PathVariable long id,
            @RequestBody RomaneioUpdateRecord romaneio) {
        if (this.romaneioFacade.findById(id) == null) {
            throw new ErrorException("Romaneio com id " + id + " nao encontrado.", 404);
        }

        Romaneio romaneioInb = romaneioFacade.update(id, romaneio);
        return new ResponseEntity<Romaneio>(romaneioInb, HttpStatus.OK);
    }

    @PutMapping("/update/codigo/{codigo}")
    public ResponseEntity<Romaneio> update(
            @PathVariable String codigo,
            @RequestBody RomaneioUpdateRecord romaneio) {
        if (this.romaneioFacade.findByCodigoUid(codigo) == null) {
            throw new ErrorException("Romaneio com codigo " + codigo + " nao encontrado.", 404);
        }

        Romaneio romaneioInb = romaneioFacade.update(codigo, romaneio);
        return new ResponseEntity<Romaneio>(romaneioInb, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        if (this.romaneioFacade.findById(id) == null) {
            throw new ErrorException("Romaneio com id " + id + " nao encontrado.", 404);
        }

        romaneioFacade.deleteById(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/findByStatus/{sts}")
    public ResponseEntity<?> findByStatus(@PathVariable String sts) {
        List<Romaneio> romaneio = this.romaneioFacade.findByStatus(sts);

        if (romaneio == null || romaneio.isEmpty()) {
            throw new ErrorException("Romaneios com status " + sts + " nao encontrado.", 404);
        }

        return new ResponseEntity<List<Romaneio>>(romaneio, HttpStatus.OK);
    }

}

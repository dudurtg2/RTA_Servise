package com.example.empresa.applications;

import com.example.empresa.entities.Codigo;
import com.example.empresa.interfaces.ICodigoRepository;
import com.example.empresa.interfaces.IEntregadorRepository;
import com.example.empresa.interfaces.IRomaneioRepository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class CodigoApplication {

    private ICodigoRepository codigoRepository;
    private IEntregadorRepository entregadorRepository;
    private IRomaneioRepository romaneioRepository;

    public CodigoApplication(ICodigoRepository codigoRepository, IRomaneioRepository romaneioRepository, IEntregadorRepository entregadorRepository) {
        this.codigoRepository = codigoRepository;
        this.romaneioRepository = romaneioRepository;
        this.entregadorRepository = entregadorRepository;
    }

    public List<Codigo> findAll() {
        return this.codigoRepository.findAll();
    }

    public Codigo findById(long id) {
        return this.codigoRepository.findById(id);
    }

    public Codigo save(Codigo codigo) {
        return this.codigoRepository.save(codigo);
    }

    public Codigo update(long id, Codigo codigo) {
        return this.codigoRepository.update(id, codigo);
    }

    public void deleteById(long id) {
        this.codigoRepository.deleteById(id);
    }

    public List<Codigo> findByEntregadorId(long entregador) {
        return this.romaneioRepository.findByEntregador(entregadorRepository.findById(entregador))
                .stream()
                .flatMap(r -> r.getCodigos().stream())
                .collect(Collectors.toList());
    }
}


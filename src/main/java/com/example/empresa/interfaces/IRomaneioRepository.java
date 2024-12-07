package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.empresa.entities.Entregador;
import com.example.empresa.entities.Motorista;
import com.example.empresa.entities.Romaneio;

@Repository
public interface IRomaneioRepository {
    List<Romaneio> findAll();
    Romaneio findById(long id);
    Romaneio save(Romaneio romaneio);
    Romaneio update(long id, Romaneio romaneio);
    void deleteById(long id);
    List<Romaneio> findByStatus(String status);
    List<Romaneio> findByMotorista(Motorista motorista);
    List<Romaneio> findByEntregador(Entregador entregador);
    Romaneio findByCodigoUid(String codigoUid);
}

package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.empresa.entities.Romaneio;

@Repository
public interface IRomaneioRepository {
    List<Romaneio> findAll();
    Romaneio findById(int id);
    Romaneio save(Romaneio romaneio);
    Romaneio update(int id, Romaneio romaneio);
    void deleteById(int id);
}
   


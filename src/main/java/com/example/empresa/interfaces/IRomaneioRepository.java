package com.example.empresa.interfaces;

import com.example.empresa.entities.Romaneio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IRomaneioRepository {
    List<Romaneio> findAll();
    Romaneio findById(int id);
    @Transactional
    Romaneio save(Romaneio romaneio);
    @Transactional
    Romaneio update(int id, Romaneio romaneio);
    void deleteById(int id);
}
   


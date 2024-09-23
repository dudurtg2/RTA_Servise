package com.example.empresa.interfaces;

import com.example.empresa.entities.Motorista;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMotoristaRepository {
    List<Motorista> findAll();
    Motorista findById(int id);
    Motorista save(Motorista motorista);
    Motorista update(int id, Motorista motorista);
    void deleteById(int id);
}
   

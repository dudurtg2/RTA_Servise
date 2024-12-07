package com.example.empresa.interfaces;

import com.example.empresa.entities.Motorista;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMotoristaRepository {
    List<Motorista> findAll();
    Motorista findById(long id);
    Motorista save(Motorista motorista);
    Motorista update(long id, Motorista motorista);
    void deleteById(long id);
    Motorista findByEmail(String email);
    Motorista findByCpf(String cpf);
}

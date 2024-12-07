package com.example.empresa.interfaces;

import com.example.empresa.entities.Entregador;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEntregadorRepository {
    List<Entregador> findAll();
    Entregador findById(long id);
    Entregador save(Entregador entregador);
    Entregador update(long id, Entregador entregador);
    void deleteById(long id);
    Entregador findByEmail(String email);
    Entregador findByCpf(String cpf);
}


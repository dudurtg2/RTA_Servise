package com.example.empresa.interfaces;

import com.example.empresa.entities.Entregador;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEntregadorRepository {
    List<Entregador> findAll();
    Entregador findById(int id);
    Entregador save(Entregador entregador);
    Entregador update(int id, Entregador entregador);
    void deleteById(int id);
}
   

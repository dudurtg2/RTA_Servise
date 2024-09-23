package com.example.empresa.interfaces;

import com.example.empresa.entities.Historico;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistoricoRepository {
    List<Historico> findAll();
    Historico findById(int id);
    Historico save(Historico historico);
    Historico update(int id, Historico historico);
    void deleteById(int id);
}
   

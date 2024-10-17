package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.empresa.entities.Regiao;

@Repository
public interface IRegiaoRepository {
    List<Regiao> findAll();
    Regiao findById(int id);
    Regiao save(Regiao Regiao);
    Regiao update(int id, Regiao Regiao);
    void deleteById(int id);
}
   


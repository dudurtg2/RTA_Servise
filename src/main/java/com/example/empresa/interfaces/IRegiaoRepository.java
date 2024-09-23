package com.example.empresa.interfaces;

import com.example.empresa.entities.Regiao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IRegiaoRepository {
    List<Regiao> findAll();
    Regiao findById(int id);
    @Transactional
    Regiao save(Regiao Regiao);
    @Transactional
    Regiao update(int id, Regiao Regiao);
    void deleteById(int id);
}
   


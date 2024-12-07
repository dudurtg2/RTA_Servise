package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.empresa.entities.Regiao;


@Repository
public interface IRegiaoRepository {

    List<Regiao> findAll();
    Regiao findById(long id);
    Regiao save(Regiao regiao);
    Regiao update(long id, Regiao regiao);
    void deleteById(long id);
}

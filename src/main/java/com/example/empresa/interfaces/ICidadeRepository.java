package com.example.empresa.interfaces;

import com.example.empresa.entities.Cidade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICidadeRepository {
    List<Cidade> findAll();
    Cidade findById(long id);
    Cidade save(Cidade cidade);
    Cidade update(long id, Cidade cidade);
    void deleteById(long id);
}


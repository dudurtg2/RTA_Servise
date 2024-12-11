package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.empresa.entities.Cidade;

@Repository
public interface ICidadeRepository {
    List<Cidade> findAll();
    Cidade findById(long id);
    Cidade save(Cidade cidade);
    Cidade update(long id, Cidade cidade);
    void deleteById(long id);
    List<Cidade> findByRegiao(long id);
}


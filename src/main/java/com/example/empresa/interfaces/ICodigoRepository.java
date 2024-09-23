package com.example.empresa.interfaces;

import com.example.empresa.entities.Codigo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICodigoRepository {
    List<Codigo> findAll();
    Codigo findById(int id);
    Codigo save(Codigo codigo);
    Codigo update(int id, Codigo codigo);
    void deleteById(int id);
}
   

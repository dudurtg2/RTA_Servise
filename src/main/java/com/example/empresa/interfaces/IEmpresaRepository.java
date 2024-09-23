package com.example.empresa.interfaces;

import com.example.empresa.entities.Empresa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpresaRepository {
    List<Empresa> findAll();
    Empresa findById(int id);
    Empresa save(Empresa empresa);
    Empresa update(int id, Empresa empresa);
    void deleteById(int id);
}
   

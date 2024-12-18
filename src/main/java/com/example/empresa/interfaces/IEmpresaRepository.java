package com.example.empresa.interfaces;

import com.example.empresa.entities.Empresa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpresaRepository {
    List<Empresa> findAll();
    Empresa findById(long id);
    Empresa save(Empresa empresa);
    Empresa update(long id, Empresa empresa);
    void deleteById(long id);
    Empresa findByCnpj(String cnpj);
}


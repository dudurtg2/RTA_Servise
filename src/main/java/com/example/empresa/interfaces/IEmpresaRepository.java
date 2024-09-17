package com.example.empresa.interfaces;

import com.example.empresa.entities.Empresa;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmpresaRepository {
    List<Empresa> buscarTodos();
    Empresa buscarPorId(int id);
    Empresa gravar(Empresa empresa);
    Empresa atualizar(int id, Empresa empresa);
    void excluir(int id);
}
   

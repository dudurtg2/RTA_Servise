package com.example.empresa.interfaces;

import com.example.empresa.entities.Codigo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICodigoRepository {
    List<Codigo> buscarTodos();
    Codigo buscarPorId(int id);
    Codigo gravar(Codigo codigo);
    Codigo atualizar(int id, Codigo codigo);
    void excluir(int id);
}
   

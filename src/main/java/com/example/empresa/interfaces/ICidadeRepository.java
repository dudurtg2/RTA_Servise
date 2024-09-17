package com.example.empresa.interfaces;

import com.example.empresa.entities.Cidade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICidadeRepository {
    List<Cidade> buscarTodos();
    Cidade buscarPorId(int id);
    Cidade gravar(Cidade cidade);
    Cidade atualizar(int id, Cidade cidade);
    void excluir(int id);
}
   

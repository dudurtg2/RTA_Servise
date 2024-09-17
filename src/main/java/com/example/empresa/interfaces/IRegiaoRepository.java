package com.example.empresa.interfaces;

import com.example.empresa.entities.Regiao;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IRegiaoRepository {
    List<Regiao> buscarTodos();
    Regiao buscarPorId(int id);
    @Transactional
    Regiao gravar(Regiao Regiao);
    @Transactional
    Regiao atualizar(int id, Regiao Regiao);
    void excluir(int id);
}
   


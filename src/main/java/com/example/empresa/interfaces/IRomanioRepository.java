package com.example.empresa.interfaces;

import com.example.empresa.entities.Romaneio;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IRomanioRepository {
    List<Romaneio> buscarTodos();
    Romaneio buscarPorId(int id);
    @Transactional
    Romaneio gravar(Romaneio romaneio);
    @Transactional
    Romaneio atualizar(int id, Romaneio romaneio);
    void excluir(int id);
}
   


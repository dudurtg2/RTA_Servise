package com.example.empresa.interfaces;

import com.example.empresa.entities.Historico;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHistoricoRepository {
    List<Historico> buscarTodos();
    Historico buscarPorId(int id);
    Historico gravar(Historico historico);
    Historico atualizar(int id, Historico historico);
    void excluir(int id);
}
   

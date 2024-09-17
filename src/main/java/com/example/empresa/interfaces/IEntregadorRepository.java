package com.example.empresa.interfaces;

import com.example.empresa.entities.Entregador;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEntregadorRepository {
    List<Entregador> buscarTodos();
    Entregador buscarPorId(int id);
    Entregador gravar(Entregador entregador);
    Entregador atualizar(int id, Entregador entregador);
    void excluir(int id);
}
   

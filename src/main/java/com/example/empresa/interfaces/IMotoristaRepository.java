package com.example.empresa.interfaces;

import com.example.empresa.entities.Motorista;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMotoristaRepository {
    List<Motorista> buscarTodos();
    Motorista buscarPorId(int id);
    Motorista gravar(Motorista motorista);
    Motorista atualizar(int id, Motorista motorista);
    void excluir(int id);
}
   

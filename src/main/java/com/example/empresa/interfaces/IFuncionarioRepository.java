package com.example.empresa.interfaces;

import com.example.empresa.entities.Funcionario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFuncionarioRepository {
    List<Funcionario> buscarTodos();
    Funcionario buscarPorId(int id);
    Funcionario gravar(Funcionario funcionario);
    Funcionario atualizar(int id, Funcionario funcionario);
    void excluir(int id);
}
   

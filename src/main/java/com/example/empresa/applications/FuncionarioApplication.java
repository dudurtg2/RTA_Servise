package com.example.empresa.applications;

import com.example.empresa.repositories.FuncionarioRepository;
import com.example.empresa.entities.Funcionario;

import java.util.List;


public class FuncionarioApplication {
    FuncionarioRepository FuncionarioRepository = new FuncionarioRepository();
    
    public List<Funcionario> buscarTodos() {
        return this.FuncionarioRepository.buscarTodos();
    }

    
    public Funcionario buscarPorId(int id) {
        return this.FuncionarioRepository.buscarPorId(id);
    }

    
    public Funcionario gravar(Funcionario Funcionario) {
        return this.FuncionarioRepository.gravar(Funcionario);
    }

    
    public Funcionario atualizar(int id, Funcionario Funcionario) {
        return this.FuncionarioRepository.atualizar(id, Funcionario);
    }

    
    public void excluir(int id) {
        this.FuncionarioRepository.excluir(id);
    }


   
}

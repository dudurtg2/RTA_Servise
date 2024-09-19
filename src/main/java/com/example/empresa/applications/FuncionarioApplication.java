package com.example.empresa.applications;

import com.example.empresa.repositories.FuncionarioRepository;
import com.example.empresa.entities.Funcionario;

import java.util.List;


public class FuncionarioApplication {
    private FuncionarioRepository funcionarioRepository;

    public FuncionarioApplication(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    
    public List<Funcionario> buscarTodos() {
        return this.funcionarioRepository.buscarTodos();
    }

    
    public Funcionario buscarPorId(int id) {
        return this.funcionarioRepository.buscarPorId(id);
    }

    
    public Funcionario gravar(Funcionario Funcionario) {
        return this.funcionarioRepository.gravar(Funcionario);
    }

    
    public Funcionario atualizar(int id, Funcionario Funcionario) {
        return this.funcionarioRepository.atualizar(id, Funcionario);
    }

    
    public void excluir(int id) {
        this.funcionarioRepository.excluir(id);
    }


   
}

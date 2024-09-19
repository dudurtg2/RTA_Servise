package com.example.empresa.facades;

import com.example.empresa.applications.FuncionarioApplication;
import com.example.empresa.entities.Funcionario;

import java.util.List;


public class FuncionarioFacade {
    private FuncionarioApplication funcionarioApplication;

    public FuncionarioFacade(FuncionarioApplication funcionarioApplication) {
        this.funcionarioApplication = funcionarioApplication;
    }

    
    public List<Funcionario> buscarTodos() {
        return this.funcionarioApplication.buscarTodos();
    }

    
    public Funcionario buscarPorId(int id) {
        return this.funcionarioApplication.buscarPorId(id);
    }

    
    public Funcionario gravar(Funcionario Funcionario) {
        return this.funcionarioApplication.gravar(Funcionario);
    }

    
    public Funcionario atualizar(int id, Funcionario Funcionario) {
        return this.funcionarioApplication.atualizar(id, Funcionario);
    }

    
    public void excluir(int id) {
        this.funcionarioApplication.excluir(id);
    }


   
}

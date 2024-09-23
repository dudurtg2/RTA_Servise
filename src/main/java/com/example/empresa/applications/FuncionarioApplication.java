package com.example.empresa.applications;

import com.example.empresa.entities.Funcionario;
import com.example.empresa.interfaces.IFuncionarioRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FuncionarioApplication {
    private IFuncionarioRepository funcionarioRepository;

    public FuncionarioApplication(IFuncionarioRepository funcionarioRepository) {
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

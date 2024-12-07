package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.FuncionarioApplication;
import com.example.empresa.entities.Funcionario;

@Component
public class FuncionarioFacade {

    private FuncionarioApplication funcionarioApplication;

    public FuncionarioFacade(FuncionarioApplication funcionarioApplication) {
        this.funcionarioApplication = funcionarioApplication;
    }

    public List<Funcionario> findAll() {
        return this.funcionarioApplication.findAll();
    }

    public Funcionario findById(long id) {
        return this.funcionarioApplication.findById(id);
    }

    public Funcionario save(Funcionario funcionario) {
        return this.funcionarioApplication.save(funcionario);
    }

    public Funcionario update(long id, Funcionario funcionario) {
        return this.funcionarioApplication.update(id, funcionario);
    }

    public void deleteById(long id) {
        this.funcionarioApplication.deleteById(id);
    }
}


package com.example.empresa.facades;

import com.example.empresa.applications.FuncionarioApplication;
import com.example.empresa.entities.Funcionario;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FuncionarioFacade {
    private FuncionarioApplication funcionarioApplication;

    public FuncionarioFacade(FuncionarioApplication funcionarioApplication) {
        this.funcionarioApplication = funcionarioApplication;
    }

    
    public List<Funcionario> findAll() {
        return this.funcionarioApplication.findAll();
    }

    
    public Funcionario findById(int id) {
        return this.funcionarioApplication.findById(id);
    }

    public Funcionario findByEmail(String email) {
        return this.funcionarioApplication.findByEmail(email);
    }

    
    public Funcionario save(Funcionario Funcionario) {
        return this.funcionarioApplication.save(Funcionario);
    }

    
    public Funcionario update(int id, Funcionario Funcionario) {
        return this.funcionarioApplication.update(id, Funcionario);
    }

    
    public void deleteById(int id) {
        this.funcionarioApplication.deleteById(id);
    }


   
}

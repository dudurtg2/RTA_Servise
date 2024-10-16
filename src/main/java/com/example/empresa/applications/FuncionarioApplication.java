package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Funcionario;
import com.example.empresa.interfaces.IFuncionarioRepository;

@Component
public class FuncionarioApplication {
    private IFuncionarioRepository funcionarioRepository;

    public FuncionarioApplication(IFuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> findAll() {
        return this.funcionarioRepository.findAll();
    }

    public Funcionario findById(int id) {
        return this.funcionarioRepository.findById(id);
    }
    
    public Funcionario save(Funcionario funcionario) {

        return this.funcionarioRepository.save(funcionario);
    }

    public Funcionario update(int id, Funcionario Funcionario) {
        Funcionario funcionarioInDb = this.funcionarioRepository.findById(id);

        if (funcionarioInDb == null) {
            return null;
        }

        return this.funcionarioRepository.update(id, Funcionario);
    }

    public void deleteById(int id) {
        this.funcionarioRepository.deleteById(id);
    }
}

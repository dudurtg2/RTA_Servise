package com.example.empresa.interfaces;

import com.example.empresa.entities.Funcionario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFuncionarioRepository {
    List<Funcionario> findAll();
    Funcionario findById(int id);
    Funcionario findByEmail(String email);
    Funcionario save(Funcionario funcionario);
    Funcionario update(int id, Funcionario funcionario);
    void deleteById(int id);
}
   

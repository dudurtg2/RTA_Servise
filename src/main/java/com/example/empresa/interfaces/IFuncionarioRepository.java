package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.empresa.entities.Funcionario;

@Repository
public interface IFuncionarioRepository {
    List<Funcionario> findAll();
    Funcionario findById(int id);
    Funcionario findByEmail(String email);
    Funcionario save(Funcionario funcionario);
    Funcionario update(int id, Funcionario funcionario);
    void deleteById(int id);
}
   

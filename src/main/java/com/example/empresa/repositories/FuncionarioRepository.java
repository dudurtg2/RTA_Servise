package com.example.empresa.repositories;

import com.example.empresa.entities.Funcionario;
import com.example.empresa.interfaces.IFuncionarioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuncionarioRepository implements IFuncionarioRepository {

    @Override
    public List<Funcionario> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Funcionario findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Funcionario save(Funcionario funcionario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Funcionario update(int id, Funcionario funcionario) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

   

   
}

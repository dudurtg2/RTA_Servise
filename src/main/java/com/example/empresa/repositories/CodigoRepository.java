package com.example.empresa.repositories;

import com.example.empresa.entities.Codigo;
import com.example.empresa.interfaces.ICodigoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodigoRepository implements ICodigoRepository {

    @Override
    public List<Codigo> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public Codigo buscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Codigo gravar(Codigo codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gravar'");
    }

    @Override
    public Codigo atualizar(int id, Codigo codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void excluir(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }



   
}

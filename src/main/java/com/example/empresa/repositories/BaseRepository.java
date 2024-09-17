package com.example.empresa.repositories;

import com.example.empresa.entities.Base;
import com.example.empresa.interfaces.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseRepository implements IBaseRepository {

    @Override
    public List<Base> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public Base buscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Base gravar(Base base) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gravar'");
    }

    @Override
    public Base atualizar(int id, Base base) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void excluir(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }


   
}

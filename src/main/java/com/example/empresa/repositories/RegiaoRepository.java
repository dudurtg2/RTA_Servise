package com.example.empresa.repositories;

import com.example.empresa.entities.Base;
import com.example.empresa.entities.Regiao;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IRegiaoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegiaoRepository implements IRegiaoRepository {

    @Override
    public List<Regiao> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public Regiao buscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Regiao gravar(Regiao Regiao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gravar'");
    }

    @Override
    public Regiao atualizar(int id, Regiao Regiao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void excluir(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }




   
}

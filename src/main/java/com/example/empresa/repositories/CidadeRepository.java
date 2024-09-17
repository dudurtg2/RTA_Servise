package com.example.empresa.repositories;

import com.example.empresa.entities.Cidade;
import com.example.empresa.interfaces.ICidadeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CidadeRepository implements ICidadeRepository {

    @Override
    public List<Cidade> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public Cidade buscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Cidade gravar(Cidade cidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gravar'");
    }

    @Override
    public Cidade atualizar(int id, Cidade cidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void excluir(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }


   
}

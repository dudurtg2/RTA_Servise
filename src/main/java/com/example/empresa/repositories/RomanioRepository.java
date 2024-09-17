package com.example.empresa.repositories;

import com.example.empresa.entities.Romaneio;
import com.example.empresa.interfaces.IRomanioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RomanioRepository implements IRomanioRepository {

    @Override
    public List<Romaneio> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public Romaneio buscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Romaneio gravar(Romaneio romaneio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gravar'");
    }

    @Override
    public Romaneio atualizar(int id, Romaneio romaneio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void excluir(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }


   
}

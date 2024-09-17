package com.example.empresa.repositories;

import com.example.empresa.entities.Motorista;
import com.example.empresa.interfaces.IMotoristaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotoristaRepository implements IMotoristaRepository {

    @Override
    public List<Motorista> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public Motorista buscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Motorista gravar(Motorista motorista) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gravar'");
    }

    @Override
    public Motorista atualizar(int id, Motorista motorista) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void excluir(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }



   
}

package com.example.empresa.repositories;

import com.example.empresa.entities.Historico;
import com.example.empresa.interfaces.IHistoricoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoricoRepository implements IHistoricoRepository {

    @Override
    public List<Historico> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public Historico buscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Historico gravar(Historico historico) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gravar'");
    }

    @Override
    public Historico atualizar(int id, Historico historico) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void excluir(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }



   
}

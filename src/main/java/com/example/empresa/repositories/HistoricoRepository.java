package com.example.empresa.repositories;

import com.example.empresa.entities.Historico;
import com.example.empresa.interfaces.IHistoricoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoricoRepository implements IHistoricoRepository {

    @Override
    public List<Historico> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Historico findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Historico save(Historico historico) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Historico update(int id, Historico historico) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }



   
}

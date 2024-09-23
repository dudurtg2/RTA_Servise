package com.example.empresa.repositories;

import com.example.empresa.entities.Entregador;
import com.example.empresa.interfaces.IEntregadorRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntregadorRepository implements IEntregadorRepository {

    @Override
    public List<Entregador> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Entregador findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Entregador save(Entregador entregador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Entregador update(int id, Entregador entregador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

   
}

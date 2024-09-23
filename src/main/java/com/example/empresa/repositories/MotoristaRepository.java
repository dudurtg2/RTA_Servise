package com.example.empresa.repositories;

import com.example.empresa.entities.Motorista;
import com.example.empresa.interfaces.IMotoristaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotoristaRepository implements IMotoristaRepository {

    @Override
    public List<Motorista> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Motorista findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Motorista save(Motorista motorista) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Motorista update(int id, Motorista motorista) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }



   
}

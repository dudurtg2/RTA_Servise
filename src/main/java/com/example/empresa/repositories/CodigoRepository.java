package com.example.empresa.repositories;

import com.example.empresa.entities.Codigo;
import com.example.empresa.interfaces.ICodigoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodigoRepository implements ICodigoRepository {

    @Override
    public List<Codigo> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Codigo findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Codigo save(Codigo codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Codigo update(int id, Codigo codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }



   
}

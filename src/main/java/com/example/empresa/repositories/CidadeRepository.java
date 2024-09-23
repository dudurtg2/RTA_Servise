package com.example.empresa.repositories;

import com.example.empresa.entities.Cidade;
import com.example.empresa.interfaces.ICidadeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CidadeRepository implements ICidadeRepository {

    @Override
    public List<Cidade> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Cidade findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Cidade save(Cidade cidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Cidade update(int id, Cidade cidade) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }


   
}

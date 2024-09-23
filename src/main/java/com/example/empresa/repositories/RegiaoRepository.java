package com.example.empresa.repositories;

import com.example.empresa.entities.Regiao;
import com.example.empresa.interfaces.IRegiaoRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegiaoRepository implements IRegiaoRepository {

    @Override
    public List<Regiao> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Regiao findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Regiao save(Regiao Regiao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Regiao update(int id, Regiao Regiao) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }




   
}

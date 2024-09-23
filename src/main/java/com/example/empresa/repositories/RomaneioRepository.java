package com.example.empresa.repositories;

import com.example.empresa.entities.Romaneio;
import com.example.empresa.interfaces.IRomanioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RomaneioRepository implements IRomanioRepository {

    @Override
    public List<Romaneio> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Romaneio findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Romaneio save(Romaneio romaneio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Romaneio update(int id, Romaneio romaneio) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }


   
}

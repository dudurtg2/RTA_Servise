package com.example.empresa.repositories;

import com.example.empresa.entities.Base;
import com.example.empresa.interfaces.IBaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BaseRepository implements IBaseRepository {

    @Override
    public List<Base> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Base findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Base save(Base base) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Base update(int id, Base base) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }


   
}

package com.example.empresa.interfaces;

import com.example.empresa.entities.Base;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBaseRepository {
    List<Base> findAll();
    Base findById(int id);
    Base save(Base base);
    Base update(int id, Base base);
    void deleteById(int id);
}
   

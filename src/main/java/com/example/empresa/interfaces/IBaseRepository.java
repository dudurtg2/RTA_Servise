package com.example.empresa.interfaces;

import com.example.empresa.entities.Base;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBaseRepository {
    List<Base> findAll();
    Base findById(long id);
    Base save(Base base);
    Base update(long id, Base base);
    void deleteById(long id);
}


package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.empresa.entities.Users;

@Repository
public interface IUsersRepository {
    List<Users> findAll();
    Users findById(int id);
    Users save(Users users);
    Users update(int id, Users users);
    void deleteById(int id);
}
   


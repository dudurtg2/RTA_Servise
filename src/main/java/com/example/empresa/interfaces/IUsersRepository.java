package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.empresa.entities.Users;

@Repository
public interface IUsersRepository {

    List<Users> findAll();
    Users findById(long id);
    Users save(Users users);
    Users update(long id, Users users);
    void deleteById(long id);
    Users findByEmail(String email);
    Users findByLogin(String login);
}

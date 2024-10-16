package com.example.empresa.interfaces;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.empresa.entities.Users;

@Repository
public interface IUsersRepository {
    List<Users> findAll();
    Users findById(int id);
    @Transactional
    Users save(Users users);
    @Transactional
    Users update(int id, Users users);
    void deleteById(int id);
}
   


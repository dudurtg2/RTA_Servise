package com.example.empresa.services;

import com.example.empresa.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface GetUserService extends JpaRepository<Users, String> {
    UserDetails findByLogin(String login);
}

package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.UserRegistrationApplication;
import com.example.empresa.applications.UsersApplication;
import com.example.empresa.applications.records.DataRecord;
import com.example.empresa.entities.Users;
import com.example.empresa.security.DTO.RegisterDTO;

@Component
public class UsersFacade {

    private UsersApplication usersApplication;
    private UserRegistrationApplication userRegistrationApplication;

    public UsersFacade(UsersApplication usersApplication,UserRegistrationApplication userRegistrationApplication) {
        this.usersApplication = usersApplication;
        this.userRegistrationApplication = userRegistrationApplication;
    }

    public List<Users> findAll() {
        return this.usersApplication.findAll();
    }

    public Users findById(long id) {
        return this.usersApplication.findById(id);
    }

    public Users save(RegisterDTO users) {
        return this.userRegistrationApplication.save(users);
    }

    public Users update(long id, Users users) {

        Users usersInDb = this.usersApplication.findById(id);
        if (usersInDb == null) {
            return null;
        }

        return this.usersApplication.update(id, users);
    }

    public void deleteById(long id) {
        this.usersApplication.deleteById(id);
    }

    public DataRecord findByEmail(String email) {
        return this.usersApplication.findByEmail(email);
    }

    public Users findByLogin(String login) {
        return this.usersApplication.findByLogin(login);
    }

}


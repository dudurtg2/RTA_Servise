package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.UsersApplication;
import com.example.empresa.entities.Users;

@Component
public class UsersFacade {
    private UsersApplication usersApplication;

    public UsersFacade(UsersApplication usersApplication) {
        this.usersApplication = usersApplication;
    }
    
    
    public List<Users> findAll() {
        return this.usersApplication.findAll();
    }

    
    public Users findById(int id) {
        return this.usersApplication.findById(id);
    }

    
    public Users save(Users users) {
        return this.usersApplication.save(users);
    }

    
    public Users update(int id, Users users) {
        
        Users usersInDb = this.usersApplication.findById(id);
        if (usersInDb == null) {
            return null;
        }

        return this.usersApplication.update(id, users);
    }

    public void deleteById(int id) {
        this.usersApplication.deleteById(id);
    }


   
}

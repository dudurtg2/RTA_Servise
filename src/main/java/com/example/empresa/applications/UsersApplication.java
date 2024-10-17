package com.example.empresa.applications;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.empresa.entities.Users;
import com.example.empresa.interfaces.IUsersRepository;

@Component
public class UsersApplication {
    private IUsersRepository usersRepository;

    public UsersApplication(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
    
    
    public List<Users> findAll() {
        return this.usersRepository.findAll();
    }

    
    public Users findById(int id) {
        return this.usersRepository.findById(id);
    }

    
    public Users save(Users users) {
        return this.usersRepository.save(users);
    }

    
    public Users update(int id, Users users) {
        
        Users usersInDb = this.usersRepository.findById(id);
        if (usersInDb == null) {
            return null;
        }

        users.setSenha(new BCryptPasswordEncoder().encode(users.getSenha()));

        return this.usersRepository.update(id, users);
    }

    public void deleteById(int id) {
        this.usersRepository.deleteById(id);
    }


   
}

package com.example.empresa.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.empresa.entities.Users;
import com.example.empresa.interfaces.IUsersRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class UsersRepository implements IUsersRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Users> findAll() {
        String jpql = "SELECT b FROM Users b";
        TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
        return query.getResultList();
    }

    @Override
    public Users findById(long id) {
        return entityManager.find(Users.class, id);
    }

    @Override
    @Transactional
    public Users save(Users users) {

        entityManager.persist(users);

        return users;
    }

    @Override
    @Transactional
    public Users update(long id, Users users) {
        Users UsersInDb = entityManager.find(Users.class, id);

        UsersInDb.setLogin(users.getLogin());
        UsersInDb.setSenha(users.getSenha());

        return entityManager.merge(UsersInDb);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Users UsersInDb = entityManager.find(Users.class, id);
        if (UsersInDb != null) {
            entityManager.remove(UsersInDb);
        }
    }

    @Override
    public Users findByEmail(String email) {
        String jpql = "SELECT u FROM Users u WHERE u.login = :login";
        TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
        query.setParameter("login", email);
        try {
            return query.getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }
    
    
    @Override
    public Users findByLogin(String login) {
        String jpql = "SELECT u FROM Users u WHERE u.login = :login";
        TypedQuery<Users> query = entityManager.createQuery(jpql, Users.class);
        query.setParameter("login", login);
        try {
            return query.getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }
}

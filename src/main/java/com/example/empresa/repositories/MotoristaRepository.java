package com.example.empresa.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.empresa.entities.Motorista;
import com.example.empresa.interfaces.IMotoristaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class MotoristaRepository implements IMotoristaRepository {

   @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Motorista> findAll() {
        String jpql = "SELECT m FROM Motorista m";
        TypedQuery<Motorista> query = entityManager.createQuery(jpql, Motorista.class);
        return query.getResultList();
    }

    @Override
    public Motorista findById(long id) {
        return entityManager.find(Motorista.class, id);
    }

    @Override
    @Transactional
    public Motorista save(Motorista motorista) {
        entityManager.persist(motorista);

        return motorista;
    }

    @Override
    @Transactional
    public Motorista update(long id, Motorista motorista) {
        Motorista motoristaInDb = entityManager.find(Motorista.class, id);
        
        motoristaInDb.setNome(motorista.getNome());
        motoristaInDb.setEmail(motorista.getEmail());
        motoristaInDb.setCpf(motorista.getCpf());
        motoristaInDb.setTelefone(motorista.getTelefone());
        motoristaInDb.setBase(motorista.getBase());

        return entityManager.merge(motoristaInDb);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Motorista motoristaInDb = entityManager.find(Motorista.class, id);
        if (motoristaInDb != null) {
            entityManager.remove(motoristaInDb);
        }
    }

    
    @Override
    public Motorista findByEmail(String email) {
        String jpql = "SELECT m FROM Motorista m WHERE m.email = :email";
        TypedQuery<Motorista> query = entityManager.createQuery(jpql, Motorista.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }

}

package com.example.empresa.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.empresa.entities.Entregador;
import com.example.empresa.interfaces.IEntregadorRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class EntregadorRepository implements IEntregadorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Entregador> findAll() {
        String jpql = "SELECT e FROM Entregador e";
        TypedQuery<Entregador> query = entityManager.createQuery(jpql, Entregador.class);
        try {
            return query.getResultList();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }

    @Override
    public Entregador findById(long id) {
        return entityManager.find(Entregador.class, id);
    }

    @Override
    @Transactional
    public Entregador save(Entregador entregador) {
        entityManager.persist(entregador);

        return entregador;
    }

    @Override
    @Transactional
    public Entregador update(long id, Entregador entregador) {
        Entregador entregadorInDb = entityManager.find(Entregador.class, id);

        entregadorInDb.setNome(entregador.getNome());
        entregadorInDb.setEndereco(entregador.getEndereco());
        entregadorInDb.setEmail(entregador.getEmail());
        entregadorInDb.setCpf(entregador.getCpf());
        entregadorInDb.setTelefone(entregador.getTelefone());
        entregadorInDb.setBase(entregador.getBase());

        return entityManager.merge(entregadorInDb);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Entregador entregadorInDb = entityManager.find(Entregador.class, id);
        if (entregadorInDb != null) {
            entityManager.remove(entregadorInDb);
        }
    }

    @Override
    public Entregador findByEmail(String email) {
        String jpql = "SELECT e FROM Entregador e WHERE e.email = :email";
        TypedQuery<Entregador> query = entityManager.createQuery(jpql, Entregador.class);
        query.setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }

    
    @Override
    public Entregador findByCpf(String cpf) {
        String jpql = "SELECT e FROM Entregador e WHERE e.cpf = :cpf";
        TypedQuery<Entregador> query = entityManager.createQuery(jpql, Entregador.class);
        query.setParameter("cpf", cpf);
        try {
            return query.getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }

}

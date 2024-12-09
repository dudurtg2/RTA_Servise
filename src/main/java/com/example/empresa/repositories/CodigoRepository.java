package com.example.empresa.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.empresa.entities.Codigo;
import com.example.empresa.interfaces.ICodigoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class CodigoRepository implements ICodigoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Codigo> findAll() {
        String jpql = "SELECT c FROM Codigo c";
        TypedQuery<Codigo> query = entityManager.createQuery(jpql, Codigo.class);
        return query.getResultList();
    }

    @Override
    public Codigo findById(long id) {
        return entityManager.find(Codigo.class, id);
    }

    @Override
    @Transactional
    public Codigo save(Codigo codigo) {
        entityManager.persist(codigo);

        return codigo;
    }

    @Override
    @Transactional
    public Codigo update(long id, Codigo codigo) {
        Codigo codigoInDb = entityManager.find(Codigo.class, id);
        
        codigoInDb.setCodigo(codigo.getCodigo());
        

        return entityManager.merge(codigoInDb);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Codigo codigoInDb = entityManager.find(Codigo.class, id);
        if (codigoInDb != null) {
            entityManager.remove(codigoInDb);
        }
    }
    
    @Override
    public Codigo findByCodigo(String codigo) {
        String jpql = "SELECT c FROM Codigo c WHERE c.codigo = :codigo";
        TypedQuery<Codigo> query = entityManager.createQuery(jpql, Codigo.class);
        query.setParameter("codigo", codigo);
        
        try {
            return query.getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }
}

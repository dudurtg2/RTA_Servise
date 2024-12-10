package com.example.empresa.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.empresa.entities.Regiao;
import com.example.empresa.interfaces.IRegiaoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class RegiaoRepository implements IRegiaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Regiao> findAll() {
        String jpql = "SELECT r FROM Regiao r";
        TypedQuery<Regiao> query = entityManager.createQuery(jpql, Regiao.class);
        try {
            return query.getResultList();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }

    @Override
    public Regiao findById(long id) {
        return entityManager.find(Regiao.class, id);
    }

    @Override
    @Transactional
    public Regiao save(Regiao regiao) {
        entityManager.persist(regiao);

        return regiao;
    }

    @Override
    @Transactional
    public Regiao update(long id, Regiao regiao) {
        Regiao regiaoInDb = entityManager.find(Regiao.class, id);
        
        regiaoInDb.setNome(regiao.getNome());
        regiaoInDb.setBase(regiao.getBase());

        return entityManager.merge(regiaoInDb);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Regiao regiaoInDb = entityManager.find(Regiao.class, id);
        if (regiaoInDb != null) {
            entityManager.remove(regiaoInDb);
        }
    }
   
}

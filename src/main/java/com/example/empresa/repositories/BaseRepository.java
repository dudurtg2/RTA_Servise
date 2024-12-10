package com.example.empresa.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.empresa.entities.Base;
import com.example.empresa.interfaces.IBaseRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class BaseRepository implements IBaseRepository {

   @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Base> findAll() {
        String jpql = "SELECT b FROM Base b";
        TypedQuery<Base> query = entityManager.createQuery(jpql, Base.class);
        try {
            return query.getResultList();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }

    @Override
    public Base findById(long id) {
        return entityManager.find(Base.class, id);
    }

    @Override
    @Transactional
    public Base save(Base base) {
        entityManager.persist(base);

        return base;
    }

    @Override
    @Transactional
    public Base update(long id, Base Base) {
        Base baseInDb = entityManager.find(Base.class, id);
        
        baseInDb.setNome(Base.getNome());
        baseInDb.setEndereco(Base.getEndereco());

        return entityManager.merge(baseInDb);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Base baseInDb = entityManager.find(Base.class, id);
        if (baseInDb != null) {
            entityManager.remove(baseInDb);
        }
    }

}

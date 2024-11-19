package com.example.empresa.repositories;

import com.example.empresa.entities.Cidade;
import com.example.empresa.interfaces.ICidadeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CidadeRepository implements ICidadeRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cidade> findAll() {
        String jpql = "SELECT c FROM Cidade c";
        TypedQuery<Cidade> query = entityManager.createQuery(jpql, Cidade.class);
        return query.getResultList();
    }

    @Override
    public Cidade findById(int id) {
        return entityManager.find(Cidade.class, id);
    }

    @Override
    @Transactional
    public Cidade save(Cidade cidade) {
        entityManager.persist(cidade);

        return cidade;
    }

    @Override
    @Transactional
    public Cidade update(int id, Cidade cidade) {
        Cidade cidadeInDb = entityManager.find(Cidade.class, id);
        
        cidadeInDb.setNome(cidade.getNome());
        cidadeInDb.setRegiao(cidade.getRegiao());
        cidadeInDb.setCep(cidade.getCep());

        return entityManager.merge(cidadeInDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Cidade cidadeInDb = entityManager.find(Cidade.class, id);
        if (cidadeInDb != null) {
            entityManager.remove(cidadeInDb);
        }
    }


   
}

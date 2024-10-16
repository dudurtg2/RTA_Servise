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
        return query.getResultList();
    }

    @Override
    public Entregador findById(int id) {
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
    public Entregador update(int id, Entregador entregador) {
        Entregador entregadorInDb = entityManager.find(Entregador.class, id);
        
        entregadorInDb.setNome(entregador.getNome());
        entregadorInDb.setEndereco(entregador.getEndereco());
        entregadorInDb.setEmail(entregador.getEmail());
        entregadorInDb.setCpf(entregador.getCpf());
        entregadorInDb.setTelefone(entregador.getTelefone());
        entregadorInDb.setIdBase(entregador.getIdBase());

        return entityManager.merge(entregadorInDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Entregador entregadorInDb = entityManager.find(Entregador.class, id);
        if (entregadorInDb != null) {
            entityManager.remove(entregadorInDb);
        }
    }

}

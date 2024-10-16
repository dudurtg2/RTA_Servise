package com.example.empresa.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.empresa.entities.Historico;
import com.example.empresa.interfaces.IHistoricoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class HistoricoRepository implements IHistoricoRepository {

   @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Historico> findAll() {
        String jpql = "SELECT h FROM Historico h";
        TypedQuery<Historico> query = entityManager.createQuery(jpql, Historico.class);
        return query.getResultList();
    }

    @Override
    public Historico findById(int id) {
        return entityManager.find(Historico.class, id);
    }

    @Override
    @Transactional
    public Historico save(Historico historico) {
        entityManager.persist(historico);

        return historico;
    }

    @Override
    @Transactional
    public Historico update(int id, Historico historico) {
        Historico historicoInDb = entityManager.find(Historico.class, id);
        
        historicoInDb.setDataCriacao(historico.getDataCriacao());
        historicoInDb.setDataSaida(historico.getDataSaida());
        historicoInDb.setDataFinalizacao(historico.getDataFinalizacao());
        historicoInDb.setidRomaneio(historico.getidRomaneio());

        return entityManager.merge(historicoInDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Historico historicoInDb = entityManager.find(Historico.class, id);
        if (historicoInDb != null) {
            entityManager.remove(historicoInDb);
        }
    }

}

package com.example.empresa.repositories;

import com.example.empresa.entities.Romaneio;
import com.example.empresa.interfaces.IRomaneioRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class RomaneioRepository implements IRomaneioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Romaneio> findAll() {
        String jpql = "SELECT b FROM Romaneio r";
        TypedQuery<Romaneio> query = entityManager.createQuery(jpql, Romaneio.class);
        return query.getResultList();
    }

    @Override
    public Romaneio findById(int id) {
        return entityManager.find(Romaneio.class, id);
    }

    @Override
    @Transactional
    public Romaneio save(Romaneio romaneio) {
        entityManager.persist(romaneio);

        return romaneio;
    }

    @Override
    @Transactional
    public Romaneio update(int id, Romaneio romaneio) {
        Romaneio romaneioInDb = entityManager.find(Romaneio.class, id);
        
        romaneioInDb.setIdEmpresa(romaneio.getIdEmpresa());
        romaneioInDb.setIdMotorista(romaneio.getIdMotorista());
        romaneioInDb.setIdEntregador(romaneio.getIdEntregador());
        romaneioInDb.setIdFuncionario(romaneio.getIdFuncionario());
        romaneioInDb.setIdBase(romaneio.getIdBase());
        romaneioInDb.setIdCidade(romaneio.getIdCidade());
        romaneioInDb.setSts(romaneio.getSts());
        romaneioInDb.setQuantidade(romaneio.getQuantidade());
        romaneioInDb.setSacas(romaneio.getSacas());
        romaneioInDb.setCaixas(romaneio.getCaixas());

        return entityManager.merge(romaneioInDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Romaneio romaneioInDb = entityManager.find(Romaneio.class, id);
        if (romaneioInDb != null) {
            entityManager.remove(romaneioInDb);
        }
    }

}



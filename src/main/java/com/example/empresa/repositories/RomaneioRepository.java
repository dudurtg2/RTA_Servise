package com.example.empresa.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.empresa.entities.Romaneio;
import com.example.empresa.interfaces.IRomaneioRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class RomaneioRepository implements IRomaneioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Romaneio> findAll() {
        String jpql = "SELECT r FROM Romaneio r";
        TypedQuery<Romaneio> query = entityManager.createQuery(jpql, Romaneio.class);
        return query.getResultList();
    }

    @Override
    public Romaneio findById(long id) {
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
    public Romaneio update(long id, Romaneio romaneio) {
        Romaneio romaneioInDb = entityManager.find(Romaneio.class, id);
        
        romaneioInDb.setEmpresa(romaneio.getEmpresa());
        romaneioInDb.setMotorista(romaneio.getMotorista());
        romaneioInDb.setEntregador(romaneio.getEntregador());
        romaneioInDb.setFuncionario(romaneio.getFuncionario());
        romaneioInDb.setData(romaneio.getData());
        romaneioInDb.setBase(romaneio.getBase());
        romaneioInDb.setCidade(romaneio.getCidade());
        romaneioInDb.setSts(romaneio.getSts());
        romaneioInDb.setQuantidade(romaneio.getQuantidade());
        romaneioInDb.setCodigoUid(romaneio.getCodigoUid());
        romaneioInDb.setOcorrencia(romaneio.getOcorrencia());
        romaneioInDb.setDataFinal(romaneio.getDataFinal());
        romaneioInDb.setLinkDownload(romaneio.getLinkDownload());
        romaneioInDb.setCodigos(romaneio.getCodigos());

        return entityManager.merge(romaneioInDb);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Romaneio romaneioInDb = entityManager.find(Romaneio.class, id);
        if (romaneioInDb != null) {
            entityManager.remove(romaneioInDb);
        }
    }

    @Override
    public List<Romaneio> findByStatus(String status) {
        String jpql = "SELECT r FROM Romaneio r WHERE r.sts = :status";
        TypedQuery<Romaneio> query = entityManager.createQuery(jpql, Romaneio.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    

}



package com.example.empresa.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.empresa.entities.Empresa;
import com.example.empresa.interfaces.IEmpresaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class EmpresaRepository implements IEmpresaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Empresa> findAll() {
        String jpql = "SELECT e FROM Empresa e";
        TypedQuery<Empresa> query = entityManager.createQuery(jpql, Empresa.class);
        try {
            return query.getResultList();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }

    @Override
    public Empresa findById(long id) {
        return entityManager.find(Empresa.class, id);
    }

    @Override
    @Transactional
    public Empresa save(Empresa empresa) {
        entityManager.persist(empresa);

        return empresa;
    }

    @Override
    @Transactional
    public Empresa update(long id, Empresa empresa) {
        Empresa empresaInDb = entityManager.find(Empresa.class, id);

        empresaInDb.setNome(empresa.getNome());
        empresaInDb.setCnpj(empresa.getCnpj());

        return entityManager.merge(empresaInDb);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        Empresa empresaInDb = entityManager.find(Empresa.class, id);
        if (empresaInDb != null) {
            entityManager.remove(empresaInDb);
        }
    }

    @Override
    public Empresa findByCnpj(String cnpj) {
        String jpql = "SELECT e FROM Empresa e WHERE e.cnpj = :cnpj";
        TypedQuery<Empresa> query = entityManager.createQuery(jpql, Empresa.class);
        query.setParameter("cnpj", cnpj);
        try {
            return query.getSingleResult();
        } catch (jakarta.persistence.NoResultException e) {
            return null;
        }
    }
}

package com.example.empresa.repositories;

import com.example.empresa.entities.Empresa;
import com.example.empresa.interfaces.IEmpresaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmpresaRepository implements IEmpresaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Empresa> findAll() {
        String jpql = "SELECT e FROM Empresa e";
        TypedQuery<Empresa> query = entityManager.createQuery(jpql, Empresa.class);
        return query.getResultList();
    }

    @Override
    public Empresa findById(int id) {
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
    public Empresa update(int id, Empresa empresa) {
        Empresa empresaInDb = entityManager.find(Empresa.class, id);
        
        empresaInDb.setNome(empresa.getNome());
        empresaInDb.setCnpj(empresa.getCnpj());

        return entityManager.merge(empresaInDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Empresa empresaInDb = entityManager.find(Empresa.class, id);
        if (empresaInDb != null) {
            entityManager.remove(empresaInDb);
        }
    }
}

package com.example.empresa.repositories;

import com.example.empresa.entities.Empresa;
import com.example.empresa.interfaces.ISystemRTARepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmpresaRepository implements ISystemRTARepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Empresa> buscarTodos() {
        String jpql = "SELECT e FROM Empresa e";
        TypedQuery<Empresa> query = entityManager.createQuery(jpql, Empresa.class);
        return query.getResultList();
    }

    @Override
    public Empresa buscarPorId(int id) {
        return entityManager.find(Empresa.class, id);
    }

    @Override
    @Transactional
    public Empresa gravar(Empresa empresa) {
        entityManager.persist(empresa);
        return empresa;
    }

    @Override
    public Empresa atualizar(int id, Empresa empresaAtualizada) {
        Empresa empresa = entityManager.find(Empresa.class, id);
        if (empresa != null) {
            empresa.setNome(empresaAtualizada.getNome());
            empresa.setCnpj(empresaAtualizada.getCnpj());
            return entityManager.merge(empresa);
        }
        return null;
    }

    @Override
    public void excluir(int id) {
        Empresa empresa = entityManager.find(Empresa.class, id);
        if (empresa != null) {
            entityManager.remove(empresa);
        }
    }
}

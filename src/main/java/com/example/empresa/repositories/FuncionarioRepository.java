package com.example.empresa.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.empresa.entities.Funcionario;
import com.example.empresa.interfaces.IFuncionarioRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

@Repository
public class FuncionarioRepository implements IFuncionarioRepository {

   @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Funcionario> findAll() {
        String jpql = "SELECT f FROM Funcionario f";
        TypedQuery<Funcionario> query = entityManager.createQuery(jpql, Funcionario.class);
        return query.getResultList();
    }

    @Override
    public Funcionario findById(int id) {
        return entityManager.find(Funcionario.class, id);
    }

    @Override
    public Funcionario findByEmail(String email) {
        String jpql = "SELECT f FROM Funcionario f WHERE f.email = :email";
        TypedQuery<Funcionario> query = entityManager.createQuery(jpql, Funcionario.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public Funcionario save(Funcionario funcionario) {
        entityManager.persist(funcionario);

        return funcionario;
    }

    @Override
    @Transactional
    public Funcionario update(int id, Funcionario funcionario) {
        Funcionario funcionarioInDb = entityManager.find(Funcionario.class, id);

        funcionarioInDb.setNome(funcionario.getNome());
        funcionarioInDb.setEmail(funcionario.getEmail());
        funcionarioInDb.setCpf(funcionario.getCpf());
        funcionarioInDb.setTelefone(funcionario.getTelefone());
        funcionarioInDb.setBase(funcionario.getBase());

        return entityManager.merge(funcionarioInDb);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Funcionario funcionarioInDb = entityManager.find(Funcionario.class, id);
        if (funcionarioInDb != null) {
            entityManager.remove(funcionarioInDb);
        }
    }

}
   

   


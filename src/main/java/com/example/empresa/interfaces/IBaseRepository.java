package com.example.empresa.interfaces;

import com.example.empresa.entities.Base;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBaseRepository {
    List<Base> buscarTodos();
    Base buscarPorId(int id);
    Base gravar(Base base);
    Base atualizar(int id, Base base);
    void excluir(int id);
}
   

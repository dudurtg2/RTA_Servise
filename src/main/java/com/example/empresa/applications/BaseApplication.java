package com.example.empresa.applications;

import com.example.empresa.repositories.BaseRepository;
import com.example.empresa.entities.Base;

import java.util.List;


public class BaseApplication {
    BaseRepository baseRepository = new BaseRepository();
    
    public List<Base> buscarTodos() {
        return this.baseRepository.buscarTodos();
    }

    
    public Base buscarPorId(int id) {
        return this.baseRepository.buscarPorId(id);
    }

    
    public Base gravar(Base base) {
        return this.baseRepository.gravar(base);
    }

    
    public Base atualizar(int id, Base base) {
        return this.baseRepository.atualizar(id, base);
    }

    
    public void excluir(int id) {
        this.baseRepository.excluir(id);
    }


   
}

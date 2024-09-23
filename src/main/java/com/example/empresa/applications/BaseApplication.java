package com.example.empresa.applications;

import com.example.empresa.entities.Base;
import com.example.empresa.interfaces.IBaseRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BaseApplication {
    private IBaseRepository baseRepository;

    public BaseApplication(IBaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }
    
    
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

package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Base;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.services.ErrorException;

@Component
public class BaseApplication {

    private IBaseRepository baseRepository;

    public BaseApplication(IBaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    public List<Base> findAll() {
        return this.baseRepository.findAll();
    }

    public Base findById(long id) {
        return this.baseRepository.findById(id);
    }

    public Base save(Base base) {
        return this.baseRepository.save(base);
    }

    public Base update(long id, Base base) {
        Base baseInDb = this.baseRepository.findById(id);
        
        if (baseInDb == null) throw new ErrorException("Base nao encontrada", 404);
        
        return this.baseRepository.update(id, base);
    }
    
    public void deleteById(long id) {
        this.baseRepository.deleteById(id);
    }
}


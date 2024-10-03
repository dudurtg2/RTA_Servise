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
    
    
    public List<Base> findAll() {
        return this.baseRepository.findAll();
    }

    
    public Base findById(int id) {
        return this.baseRepository.findById(id);
    }

    
    public Base save(Base base) {
        return this.baseRepository.save(base);
    }

    
    public Base update(int id, Base base) {
        
        Base baseInDb = this.baseRepository.findById(id);
        if (baseInDb == null) {
            return null;
        }

        return this.baseRepository.update(id, base);
    }



    
    public void deleteById(int id) {
        this.baseRepository.deleteById(id);
    }


   
}

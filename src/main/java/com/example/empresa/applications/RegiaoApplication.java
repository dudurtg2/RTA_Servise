package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Regiao;
import com.example.empresa.interfaces.IRegiaoRepository;

@Component
public class RegiaoApplication {
    private IRegiaoRepository regiaoRepository;

    public RegiaoApplication(IRegiaoRepository regiaoRepository) {
        this.regiaoRepository = regiaoRepository;
    }
    

    public List<Regiao> findAll() {
        return this.regiaoRepository.findAll();
    }

    
    public Regiao findById(int id) {
        return this.regiaoRepository.findById(id);
    }

    
    public Regiao save(Regiao regiao) {
        return this.regiaoRepository.save(regiao);
    }

    
    public Regiao update(int id, Regiao regiao) {
        Regiao regiaoInDb = this.regiaoRepository.findById(id);

        if (regiaoInDb == null) {
            return null;
        }
        return this.regiaoRepository.update(id, regiao);
    }

    
    public void deleteById(int id) {
        this.regiaoRepository.deleteById(id);
    }


   
}

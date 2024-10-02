package com.example.empresa.applications;

import com.example.empresa.entities.Historico;
import com.example.empresa.interfaces.IHistoricoRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class HistoricoApplication {
    private IHistoricoRepository historicoRepository;


    public HistoricoApplication(IHistoricoRepository historicoRepository) {
        this.historicoRepository = historicoRepository;
    }
    
    public List<Historico> findAll() {
        return this.historicoRepository.findAll();
    }

    
    public Historico findById(int id) {
        return this.historicoRepository.findById(id);
    }

    
    public Historico save(Historico Historico) {
        return this.historicoRepository.save(Historico);
    }

    
    public Historico update(int id, Historico Historico) {
        Historico historicoInDb = this.historicoRepository.findById(id);

        if (historicoInDb == null) {
            return null;
        }

        return this.historicoRepository.update(id, Historico);
    }

    
    public void deleteById(int id) {
        this.historicoRepository.deleteById(id);
    }


   
}

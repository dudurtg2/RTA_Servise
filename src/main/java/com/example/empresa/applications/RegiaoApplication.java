package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Regiao;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IRegiaoRepository;
import com.example.empresa.services.ErrorException;

@Component
public class RegiaoApplication {
    private IRegiaoRepository regiaoRepository;
    private IBaseRepository baseRepository;

    public RegiaoApplication(IRegiaoRepository regiaoRepository, IBaseRepository baseRepository) {
        this.regiaoRepository = regiaoRepository;
        this.baseRepository = baseRepository;
    }

    public List<Regiao> findAll() {
        return this.regiaoRepository.findAll();
    }

    public Regiao findById(long id) {
        return this.regiaoRepository.findById(id);
    }

    public Regiao save(Regiao regiao) {
        if (baseRepository.findById(regiao.getBase().getId()) == null) throw new ErrorException("Base nao encontrada", 404);
        return this.regiaoRepository.save(regiao);
    }

    public Regiao update(long id, Regiao regiao) {
        Regiao regiaoInDb = this.regiaoRepository.findById(id);

        if (regiaoInDb == null) {
            return null;
        }
        return this.regiaoRepository.update(id, regiao);
    }

    public void deleteById(long id) {
        this.regiaoRepository.deleteById(id);
    }
}


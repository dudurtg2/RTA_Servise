package com.example.empresa.facades;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.applications.RegiaoApplication;
import com.example.empresa.entities.Regiao;

@Component
public class RegiaoFacade {

    private RegiaoApplication regiaoApplication;

    public RegiaoFacade(RegiaoApplication regiaoApplication) {
        this.regiaoApplication = regiaoApplication;
    }

    public List<Regiao> findAll() {
        return this.regiaoApplication.findAll();
    }

    public Regiao findById(long id) {
        return this.regiaoApplication.findById(id);
    }

    public Regiao save(Regiao regiao) {
        return this.regiaoApplication.save(regiao);
    }

    public Regiao update(long id, Regiao regiao) {
        return this.regiaoApplication.update(id, regiao);
    }

    public void deleteById(long id) {
        this.regiaoApplication.deleteById(id);
    }
}


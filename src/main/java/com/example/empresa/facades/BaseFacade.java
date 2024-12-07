package com.example.empresa.facades;

import com.example.empresa.applications.BaseApplication;
import com.example.empresa.entities.Base;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class BaseFacade {

    private BaseApplication baseApplication;

    public BaseFacade(BaseApplication baseApplication) {
        this.baseApplication = baseApplication;
    }

    public List<Base> findAll() {
        return this.baseApplication.findAll();
    }

    public Base findById(long id) {
        return this.baseApplication.findById(id);
    }

    public Base save(Base base) {
        return this.baseApplication.save(base);
    }

    public Base update(long id, Base base) {
        return this.baseApplication.update(id, base);
    }

    public void deleteById(long id) {
        this.baseApplication.deleteById(id);
    }
}


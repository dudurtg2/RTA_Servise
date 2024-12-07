package com.example.empresa.facades;

import com.example.empresa.applications.EmpresaApplication;
import com.example.empresa.entities.Empresa;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmpresaFacade {

    private EmpresaApplication empresaApplication;

    public EmpresaFacade(EmpresaApplication empresaApplication) {
        this.empresaApplication = empresaApplication;
    }

    public List<Empresa> findAll() {
        return this.empresaApplication.findAll();
    }

    public Empresa findById(long id) {
        return this.empresaApplication.findById(id);
    }

    public Empresa save(Empresa empresa) {
        return this.empresaApplication.save(empresa);
    }

    public Empresa update(long id, Empresa empresa) {
        return this.empresaApplication.update(id, empresa);
    }

    public void deleteById(long id) {
        this.empresaApplication.deleteById(id);
    }
}


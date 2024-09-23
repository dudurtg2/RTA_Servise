package com.example.empresa.applications;

import com.example.empresa.entities.Empresa;
import com.example.empresa.interfaces.IEmpresaRepository;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmpresaApplication {
    
    private IEmpresaRepository empresaRepository;

    public EmpresaApplication(IEmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }
    
    
    public List<Empresa> findAll() {
        return this.empresaRepository.findAll();
    }

    
    public Empresa findById(int id) {
        return this.empresaRepository.findById(id);
    }

    
    public Empresa save(Empresa Empresa) {
        return this.empresaRepository.save(Empresa);
    }

    
    public Empresa update(int id, Empresa Empresa) {
        return this.empresaRepository.update(id, Empresa);
    }

    
    public void deleteById(int id) {
        this.empresaRepository.deleteById(id);
    }


   
}

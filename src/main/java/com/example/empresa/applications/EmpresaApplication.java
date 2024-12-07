package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Empresa;
import com.example.empresa.interfaces.IEmpresaRepository;
import com.example.empresa.services.ErrorException;

@Component
public class EmpresaApplication {
    
    private IEmpresaRepository empresaRepository;

    public EmpresaApplication(IEmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }
    
    public List<Empresa> findAll() {
        return this.empresaRepository.findAll();
    }


    public Empresa findById(long id) {
        return this.empresaRepository.findById(id);
    }

    public Empresa save(Empresa empresa) {
        empresa.setCnpj(formatCnpj(empresa.getCnpj()));

        if(empresa.getCnpj() == null) throw new ErrorException("Cnpj invalido", 400);

        return this.empresaRepository.save(empresa);
    }
    public Empresa update(long id, Empresa empresa) {
        empresa.setCnpj(formatCnpj(empresa.getCnpj()));

        if(empresa.getCnpj() == null) throw new ErrorException("Cnpj invalido", 400);
        return this.empresaRepository.update(id, empresa);
    }

    public void deleteById(long id) {
        this.empresaRepository.deleteById(id);
    }

    private String formatCnpj(String cnpj) {
        String cnpjInValidate = cnpj.replaceAll("[^\\d]", "");
    
        if (cnpjInValidate.length() != 14) {
            return null;
        }
        return cnpjInValidate.substring(0, 2) + "." + 
               cnpjInValidate.substring(2, 5) + "." + 
               cnpjInValidate.substring(5, 8) + "/" + 
               cnpjInValidate.substring(8, 12) + "-" + 
               cnpjInValidate.substring(12);
    }

    
}

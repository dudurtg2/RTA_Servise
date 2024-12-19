package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Empresa;
import com.example.empresa.interfaces.IEmpresaRepository;
import com.example.empresa.services.ErrorException;
import com.example.empresa.services.ValidateServise;

@Component
public class EmpresaApplication {
    
    private IEmpresaRepository empresaRepository;
    private ValidateServise validateServise;

    public EmpresaApplication(IEmpresaRepository empresaRepository, ValidateServise validateServise) {
        this.empresaRepository = empresaRepository;
        this.validateServise = validateServise;
    }
    
    
    public List<Empresa> findAll() {
        return this.empresaRepository.findAll();
    }


    public Empresa findById(long id) {
        return this.empresaRepository.findById(id);
    }

    public Empresa save(Empresa empresa) {
        empresa.setCnpj(getCnpjExistente(empresa.getCnpj()));

        return this.empresaRepository.save(empresa);
    }
    public Empresa update(long id, Empresa empresa) {
        empresa.setCnpj(getCnpjExistente(empresa.getCnpj()));
        
        return this.empresaRepository.update(id, empresa);
    }

    public void deleteById(long id) {
        this.empresaRepository.deleteById(id);
    }

    private String getCnpjExistente(String cnpj) {
        String cnpjFormatado = validateServise.cnpj(cnpj);

        if (cnpjFormatado.isEmpty()) throw new ErrorException("CNPJ inválido", 409);
        if (this.empresaRepository.findByCnpj(cnpj) != null) throw new ErrorException("CNPJ já cadastrado", 409);
        
        return cnpjFormatado;
    }

    
}

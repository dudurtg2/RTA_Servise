package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Cidade;
import com.example.empresa.interfaces.ICidadeRepository;
import com.example.empresa.services.ValidacaoService;

@Component
public class CidadeApplication {
    private ICidadeRepository cidadeRepository;

    public CidadeApplication(ICidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }
    
    public List<Cidade> findAll() {
        return this.cidadeRepository.findAll();
    }

    
    public Cidade findById(int id) {
        return this.cidadeRepository.findById(id);
    }

    
    public Cidade save(Cidade cidade ) {
        cidade.setCep(new ValidacaoService().Cep(cidade.getCep()));

        if (cidade.getCep().equals("invalido")) {
            return null;
        }

        return this.cidadeRepository.save(cidade);
    }

    
    public Cidade update(int id, Cidade cidade ) {
        Cidade cidadeInDb = this.cidadeRepository.findById(id);

        if (cidadeInDb == null) {
            return null;
        }
        
        cidade.setCep(new ValidacaoService().Cep(cidade.getCep()));

        if (cidade.getCep().equals("invalido")) {
            return null;
        }

        return this.cidadeRepository.update(id, cidade);
    }

    
    public void deleteById(int id) {
        this.cidadeRepository.deleteById(id);
    }

   
}

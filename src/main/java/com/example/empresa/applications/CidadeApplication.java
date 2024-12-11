package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Cidade;
import com.example.empresa.interfaces.ICidadeRepository;
import com.example.empresa.interfaces.IRegiaoRepository;
import com.example.empresa.services.ErrorException;

@Component
public class CidadeApplication {
    private ICidadeRepository cidadeRepository;
    private IRegiaoRepository regiaoRepository;

    public CidadeApplication(ICidadeRepository cidadeRepository, IRegiaoRepository regiaoRepository) {
        this.cidadeRepository = cidadeRepository;
        this.regiaoRepository = regiaoRepository;
    }

    public List<Cidade> findAll() {
        return this.cidadeRepository.findAll();
    }

    public Cidade findById(long id) {
        return this.cidadeRepository.findById(id);
    }

    public Cidade save(Cidade cidade) {
        cidade.setCep(formatCep(cidade.getCep()));
        if (cidade.getCep() == null) throw new ErrorException("Cep invalido", 400);
        if (regiaoRepository.findById(cidade.getRegiao().getId()) == null) throw new ErrorException("Região nao encontrada", 400);
        return this.cidadeRepository.save(cidade);
    }

    public Cidade update(long id, Cidade cidade) {
        cidade.setCep(formatCep(cidade.getCep()));
        if (cidade.getCep() == null) throw new ErrorException("Cep invalido", 400);
        return this.cidadeRepository.update(id, cidade);
    }

    public void deleteById(long id) {
        this.cidadeRepository.deleteById(id);
    }

    private String formatCep(String cep) {
        String cepInValidate = cep.replaceAll("[^\\d]", "");
        if (cepInValidate.length() != 8) {
            return null;
        }
        return cepInValidate.substring(0, 5) + "-" + cepInValidate.substring(5);
    }

    public List<Cidade> findByRegiao(long id) {
        if (regiaoRepository.findById(id) == null) throw new ErrorException("Regiao nao encontrada", 400);

        List<Cidade> cidades = this.cidadeRepository.findByRegiao(id);

        if (cidades == null) throw new ErrorException("Cidades da região não encontrada", 404);
        return cidades;
    }
}


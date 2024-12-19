package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Entregador;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IEntregadorRepository;
import com.example.empresa.services.ErrorException;
import com.example.empresa.services.ValidateServise;

@Component
public class EntregadorApplication {
    private IEntregadorRepository entregadorRepository;
    private IBaseRepository baseRepository;
    private ValidateServise validateServise;

    public EntregadorApplication(IEntregadorRepository entregadorRepository, IBaseRepository baseRepository, ValidateServise validateServise) {
        this.entregadorRepository = entregadorRepository;
        this.baseRepository = baseRepository;
        this.validateServise = validateServise;
    }

    public List<Entregador> findAll() {
        return this.entregadorRepository.findAll();
    }

    public Entregador findById(long id) {
        return this.entregadorRepository.findById(id);
    }

    public Entregador save(Entregador entregador) {
        entregador.setEmail(entregador.getEmail().toLowerCase());

        if (baseRepository.findById(entregador.getBase().getId()) == null) throw new ErrorException("Base nao cadastrada", 409);
        
        entregador.setCpf(getCpfExistente(entregador.getCpf()));

        return this.entregadorRepository.save(entregador);
    }

    private String getCpfExistente(String cpf) {
        String cpfFormatado = validateServise.cpf(cpf);

        if (cpfFormatado.isEmpty()) throw new ErrorException("CPF inválido", 409);
        if (this.entregadorRepository.findByCpf(cpf) != null) throw new ErrorException("CPF já cadastrado", 409);
        
        return cpfFormatado;
    }


    public Entregador update(long id, Entregador entregador) {
        entregador.setEmail(entregador.getEmail().toLowerCase());

        entregador.setCpf(getCpfExistente(entregador.getCpf()));

        return this.entregadorRepository.update(id, entregador);
    }

    public void deleteById(long id) {
        this.entregadorRepository.deleteById(id);
    }

    public Entregador findByEmail(String email) {
        return this.entregadorRepository.findByEmail(email);
    }
}


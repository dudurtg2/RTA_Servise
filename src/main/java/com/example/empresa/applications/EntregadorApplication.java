package com.example.empresa.applications;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.empresa.entities.Entregador;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IEntregadorRepository;
import com.example.empresa.services.ErrorException;

@Component
public class EntregadorApplication {
    private IEntregadorRepository entregadorRepository;
    private IBaseRepository baseRepository;

    public EntregadorApplication(IEntregadorRepository entregadorRepository, IBaseRepository baseRepository) {
        this.entregadorRepository = entregadorRepository;
        this.baseRepository = baseRepository;
    }

    public List<Entregador> findAll() {
        return this.entregadorRepository.findAll();
    }

    public Entregador findById(long id) {
        return this.entregadorRepository.findById(id);
    }

    public Entregador save(Entregador entregador) {
        entregador.setEmail(entregador.getEmail().toLowerCase());

        if (baseRepository.findById(entregador.getBase().getId()) == null) throw new ErrorException("Base nao cadastrada", 400);
        
        entregador.setCpf(getCpfExistente(entregador.getCpf()));

        return this.entregadorRepository.save(entregador);
    }

    private String getCpfExistente(String cpf) {
        String cpfFormatado = formatCpf(cpf);

        if ("invalido".equals(cpfFormatado)) throw new ErrorException("CPF inválido", 400);
        if (this.entregadorRepository.findByCpf(cpf) != null) throw new ErrorException("CPF já cadastrado", 400);
        
        return cpfFormatado;
    }

    private String formatCpf(String cpf) {
        String cpfInValidate = cpf.replaceAll("[^\\d]", "");
        
        if (cpfInValidate.length() != 11) {
            return null;
        }
        
        return cpfInValidate.substring(0, 3) + "." + cpfInValidate.substring(3, 6) + "." + cpfInValidate.substring(6, 9) + "-" + cpfInValidate.substring(9);
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


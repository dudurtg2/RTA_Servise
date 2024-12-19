package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Motorista;
import com.example.empresa.interfaces.IMotoristaRepository;
import com.example.empresa.services.ErrorException;
import com.example.empresa.services.ValidateServise;


@Component
public class MotoristaApplication {
    private IMotoristaRepository motoristaRepository;
    private ValidateServise validateServise;

    public MotoristaApplication(IMotoristaRepository motoristaRepository, ValidateServise validateServise) {
        this.motoristaRepository = motoristaRepository;
        this.validateServise = validateServise;
    }
    
    public List<Motorista> findAll() {
        return this.motoristaRepository.findAll();
    }

    public Motorista findById(long id) {
        return this.motoristaRepository.findById(id);
    }

    public Motorista save(Motorista motorista) {
        motorista.setEmail(motorista.getEmail().toLowerCase());

        if(motoristaRepository.findByEmail(motorista.getEmail()) != null) throw new ErrorException("Email já cadastrado", 409);
        
        motorista.setCpf(getCpfExistente(motorista.getCpf()));
    
        return this.motoristaRepository.save(motorista);
    }

    private String getCpfExistente(String motorista) {
        String cpfFormatado = validateServise.cpf(motorista);
        
        if (cpfFormatado.isEmpty()) throw new ErrorException("CPF inválido", 409);
        if (this.motoristaRepository.findByCpf(motorista) != null)  throw new ErrorException("CPF já cadastrado", 409);
        
        return cpfFormatado;
    }


    public Motorista update(long id, Motorista motorista) {
        Motorista motoristaInDb = this.motoristaRepository.findById(id);

        if (motoristaInDb == null) throw new ErrorException("Motorista com id " + id + " nao encontrada.", 404);

        if (motorista.getEmail() == null) motorista.setEmail(motoristaInDb.getEmail().toLowerCase());
        if (motorista.getNome() == null) motorista.setNome(motoristaInDb.getNome());
        if (motorista.getCpf() == null) motorista.setCpf(motoristaInDb.getCpf());
        if (motorista.getTelefone() == null) motorista.setTelefone(motoristaInDb.getTelefone());
        if (motorista.getBase() == null) motorista.setBase(motoristaInDb.getBase());

        return this.motoristaRepository.update(id, motorista);
    }

    public void deleteById(long id) {
        this.motoristaRepository.deleteById(id);
    }

    public Motorista findByEmail(String email) {
        return this.motoristaRepository.findByEmail(email);
    }

}


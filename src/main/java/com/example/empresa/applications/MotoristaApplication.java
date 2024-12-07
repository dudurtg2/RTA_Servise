package com.example.empresa.applications;

import java.util.List;
import org.springframework.stereotype.Component;
import com.example.empresa.entities.Motorista;
import com.example.empresa.interfaces.IMotoristaRepository;
import com.example.empresa.services.ErrorException;


@Component
public class MotoristaApplication {
    private IMotoristaRepository motoristaRepository;

    public MotoristaApplication(IMotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }
    
    public List<Motorista> findAll() {
        return this.motoristaRepository.findAll();
    }

    public Motorista findById(long id) {
        return this.motoristaRepository.findById(id);
    }

    public Motorista save(Motorista motorista) {
        motorista.setEmail(motorista.getEmail().toLowerCase());

        if(motoristaRepository.findByEmail(motorista.getEmail()) != null) throw new ErrorException("Email já cadastrado", 400);
        
        motorista.setCpf(getCpfExistente(motorista.getCpf()));
    
        return this.motoristaRepository.save(motorista);
    }

    private String getCpfExistente(String motorista) {
        String cpfFormatado = formatCpf(motorista);
        
        if ("invalido".equals(cpfFormatado)) throw new ErrorException("CPF inválido", 400);
        if (this.motoristaRepository.findByCpf(motorista) != null)  throw new ErrorException("CPF já cadastrado", 400);
        
        return cpfFormatado;
    }

    private String formatCpf(String cpf) {
        String cpfInValidate = cpf.replaceAll("[^\\d]", "");
        
        if (cpfInValidate.length() != 11) {
            return null;
        }
        
        return cpfInValidate.substring(0, 3) + "." + cpfInValidate.substring(3, 6) + "." + cpfInValidate.substring(6, 9) + "-" + cpfInValidate.substring(9);
    }

    public Motorista update(long id, Motorista motorista) {
        motorista.setEmail(motorista.getEmail().toLowerCase());

        motorista.setCpf(getCpfExistente(motorista.getCpf()));

        return this.motoristaRepository.update(id, motorista);
    }

    public void deleteById(long id) {
        this.motoristaRepository.deleteById(id);
    }

    public Motorista findByEmail(String email) {
        return this.motoristaRepository.findByEmail(email);
    }

}


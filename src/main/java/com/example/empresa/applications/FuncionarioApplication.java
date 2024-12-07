package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Funcionario;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IFuncionarioRepository;
import com.example.empresa.services.ErrorException;

@Component
public class FuncionarioApplication {
    private IFuncionarioRepository funcionarioRepository;
    private IBaseRepository baseRepository;

    public FuncionarioApplication(IFuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
        this.baseRepository = baseRepository;
    }

    public List<Funcionario> findAll() {
        return this.funcionarioRepository.findAll();
    }

    public Funcionario findById(long id) {
        return this.funcionarioRepository.findById(id);
    }
    
    public Funcionario save(Funcionario funcionario) {
        funcionario.setEmail(funcionario.getEmail().toLowerCase());

        if(baseRepository.findById(funcionario.getBase().getId()) == null) throw new ErrorException("Base nao cadastrada", 400);
        
        funcionario.setCpf(getCpfExistente(funcionario.getCpf()));
    
        return this.funcionarioRepository.save(funcionario);
    }

    private String getCpfExistente(String cpf) {
        String cpfFormatado = formatCpf(cpf);

        if ("invalido".equals(cpfFormatado)) throw new ErrorException("CPF inválido", 400);
        if (this.funcionarioRepository.findByCpf(cpf) != null) throw new ErrorException("CPF já cadastrado", 400);
        
        return cpfFormatado;
    }
    private String formatCpf(String cpf) {
        String cpfInValidate = cpf.replaceAll("[^\\d]", "");
        
        if (cpfInValidate.length() != 11) {
            return null;
        }
        
        return cpfInValidate.substring(0, 3) + "." + cpfInValidate.substring(3, 6) + "." + cpfInValidate.substring(6, 9) + "-" + cpfInValidate.substring(9);
    }

    public Funcionario update(long id, Funcionario funcionario) {
        funcionario.setEmail(funcionario.getEmail().toLowerCase());

        funcionario.setCpf(getCpfExistente(funcionario.getCpf()));

        return this.funcionarioRepository.update(id, funcionario);
    }

    public void deleteById(long id) {
        this.funcionarioRepository.deleteById(id);
    }

    public Funcionario findByEmail(String email) {
        return this.funcionarioRepository.findByEmail(email);
    }
}


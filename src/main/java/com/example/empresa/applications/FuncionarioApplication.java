package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Funcionario;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IFuncionarioRepository;
import com.example.empresa.interfaces.IUsersRepository;
import com.example.empresa.services.ErrorException;
import com.example.empresa.services.ValidateServise;

@Component
public class FuncionarioApplication {
    private IFuncionarioRepository funcionarioRepository;
    private IBaseRepository baseRepository;
    private IUsersRepository usersRepository;
    private ValidateServise validateServise;

    public FuncionarioApplication(IFuncionarioRepository funcionarioRepository, IBaseRepository baseRepository, ValidateServise validateServise, IUsersRepository usersRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.baseRepository = baseRepository;
        this.validateServise = validateServise;
        this.usersRepository = usersRepository;
    }

    public List<Funcionario> findAll() {
        return this.funcionarioRepository.findAll().stream().filter(Funcionario::isAtivo).toList();
    }

    public Funcionario findById(long id) {
        return this.funcionarioRepository.findById(id);
    }

 
    
    public Funcionario save(Funcionario funcionario) {
        funcionario.setEmail(funcionario.getEmail().toLowerCase());
        funcionario.setAtivo(true);
        
        funcionario.setCpf(getCpfExistente(funcionario.getCpf()));
    
        return this.funcionarioRepository.save(funcionario);
    }

    private String getCpfExistente(String cpf) {
        String cpfFormatado = validateServise.cpf(cpf);

        if (cpfFormatado.isEmpty()) throw new ErrorException("CPF inválido", 409);
        if (this.funcionarioRepository.findByCpf(cpf) != null) throw new ErrorException("CPF já cadastrado", 409);
        
        return cpfFormatado;
    }

    public Funcionario update(long id, Funcionario funcionario) {
        funcionario.setEmail(funcionario.getEmail().toLowerCase());

        funcionario.setCpf(getCpfExistente(funcionario.getCpf()));

        return this.funcionarioRepository.update(id, funcionario);
    }

    public void deleteById(long id) {
        Funcionario funcionario = this.funcionarioRepository.findById(id);
        if (funcionario == null) throw new ErrorException("Funcionario com id " + id + " nao encontrada.", 404);
        this.usersRepository.deleteById(this.usersRepository.findByLogin(funcionario.getEmail()).getId());
        funcionario.setAtivo(false);
        funcionario.setEmail("DELETEUSER"+funcionario.getId()+"@DELETEUSER");
        funcionario.setCpf("00000000000");
        this.funcionarioRepository.update(funcionario.getId(), funcionario);
    }

    public Funcionario findByEmail(String email) {
        return this.funcionarioRepository.findByEmail(email);
    }
}


package com.example.empresa.applications;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.empresa.entities.Base;
import com.example.empresa.entities.Entregador;
import com.example.empresa.entities.Funcionario;
import com.example.empresa.entities.Motorista;
import com.example.empresa.entities.Users;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IEntregadorRepository;
import com.example.empresa.interfaces.IFuncionarioRepository;
import com.example.empresa.interfaces.IMotoristaRepository;
import com.example.empresa.interfaces.IUsersRepository;
import com.example.empresa.security.DTO.RegisterDTO;
import com.example.empresa.services.ErrorException;
import com.example.empresa.services.ValidateServise;


@Component
public class UserRegistrationApplication {

    private IUsersRepository usersRepository;
    private IFuncionarioRepository funcionarioRepository;
    private IMotoristaRepository motoristaRepository;
    private IEntregadorRepository entregadorRepository;
    private IBaseRepository baseRepository;
    private ValidateServise validateServise;

    public UserRegistrationApplication(IUsersRepository usersRepository,
            IFuncionarioRepository funcionarioRepository,
            IMotoristaRepository motoristaRepository,
            IEntregadorRepository entregadorRepository,
            IBaseRepository baseRepository,
            ValidateServise validateServise) {
        this.validateServise = validateServise;
        this.usersRepository = usersRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.motoristaRepository = motoristaRepository;
        this.entregadorRepository = entregadorRepository;
        this.baseRepository = baseRepository;
    }

    public Users save(RegisterDTO registerDTO) {
        if (usersRepository.findByEmail(registerDTO.email()) != null) throw new ErrorException("Email já cadastrado.", 409);
        
        registerUser(registerDTO);

        return usersRepository.save(new Users(
                registerDTO.email().toLowerCase(),
                new BCryptPasswordEncoder().encode(registerDTO.senha()),
                registerDTO.role()
        ));
    }
    private void validateCampos(RegisterDTO registerDTO) {
        if (registerDTO.email() == null ||
    registerDTO.senha() == null ||
    registerDTO.role() == null ||
    registerDTO.cpf() == null ||
    registerDTO.telefone() == null ||
    registerDTO.nome() == null) {
    throw new ErrorException("Campos obrigatórios", 400);
}

    }

    private void registerUser(RegisterDTO registerDTO) {
        List<Base> bases = validateBase(registerDTO.base());

        validateCampos(registerDTO);

        switch (registerDTO.role()) {
            case MOTORISTA:
                motoristaSave(new Motorista(
                        registerDTO.nome(),
                        registerDTO.email(),
                        registerDTO.cpf(),
                        registerDTO.telefone(),
                        bases
                ));
                break;

            case ENTREGADOR:
                entregadorSave(new Entregador(
                        registerDTO.nome(),
                        registerDTO.email(),
                        registerDTO.cpf(),
                        registerDTO.telefone(),
                        bases,
                        registerDTO.endereco()
                ));
                break;

            default:
                funcionarioSave(new Funcionario(
                        registerDTO.nome(),
                        registerDTO.email(),
                        registerDTO.cpf(),
                        registerDTO.telefone(),
                        bases,
                        registerDTO.role().toString()
                ));
                break;
        }
    }

    private List<Base> validateBase(List<Long> baseId) {
        List<Base> bases = new ArrayList<>();

        baseId.forEach(v -> {
            if (baseRepository.findById(v) == null) {
                throw new ErrorException("Base não cadastrada", 409);
            }
            bases.add(baseRepository.findById(v));
        });
        
        return bases;
    }


    private void validateCpfUniqueness(String cpf, Object repository) {
        if (repository instanceof IFuncionarioRepository) {
            Funcionario funcionario = funcionarioRepository.findByCpf(cpf);
            if (funcionario != null) {
                throw new ErrorException("CPF já cadastrado", 409);
            }
        } else if (repository instanceof IMotoristaRepository) {
            Motorista motorista = motoristaRepository.findByCpf(cpf);
            if (motorista != null) {
                throw new ErrorException("CPF já cadastrado", 409);
            }
        } else if (repository instanceof IEntregadorRepository) {
            Entregador entregador = entregadorRepository.findByCpf(cpf);
            if (entregador != null) {
                throw new ErrorException("CPF já cadastrado", 409);
            }
        }
    }

    private void motoristaSave(Motorista motorista) {
        motorista.setEmail(motorista.getEmail().toLowerCase());
        motorista.setCpf(validateServise.cpf(motorista.getCpf()));
        validateCpfUniqueness(motorista.getCpf(), motoristaRepository);
        motoristaRepository.save(motorista);
    }

    private void entregadorSave(Entregador entregador) {
        entregador.setEmail(entregador.getEmail().toLowerCase());
        entregador.setCpf(validateServise.cpf(entregador.getCpf()));
        validateCpfUniqueness(entregador.getCpf(), entregadorRepository);
        entregadorRepository.save(entregador);
    }

    private void funcionarioSave(Funcionario funcionario) {
        funcionario.setEmail(funcionario.getEmail().toLowerCase());
        funcionario.setCpf(validateServise.cpf(funcionario.getCpf()));
        validateCpfUniqueness(funcionario.getCpf(), funcionarioRepository);
        funcionarioRepository.save(funcionario);
    }

}


package com.example.empresa.applications;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

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

@Component
public class UserRegistrationApplication {

    private IUsersRepository usersRepository;
    private IFuncionarioRepository funcionarioRepository;
    private IMotoristaRepository motoristaRepository;
    private IEntregadorRepository entregadorRepository;
    private IBaseRepository baseRepository;

    public UserRegistrationApplication(IUsersRepository usersRepository,
            IFuncionarioRepository funcionarioRepository,
            IMotoristaRepository motoristaRepository,
            IEntregadorRepository entregadorRepository,
            IBaseRepository baseRepository) {
        this.usersRepository = usersRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.motoristaRepository = motoristaRepository;
        this.entregadorRepository = entregadorRepository;
        this.baseRepository = baseRepository;
    }

    public Users save(RegisterDTO registerDTO) {
        if (usersRepository.findByEmail(registerDTO.email()) != null) throw new ErrorException("Email já cadastrado.", 400);
        
        registerUser(registerDTO);

        return usersRepository.save(new Users(
                registerDTO.email().toLowerCase(),
                new BCryptPasswordEncoder().encode(registerDTO.senha()),
                registerDTO.role()
        ));
    }

    private void registerUser(RegisterDTO registerDTO) {
        validateBase(registerDTO.base());

        switch (registerDTO.role()) {
            case MOTORISTA:
                motoristaSave(new Motorista(
                        registerDTO.nome(),
                        registerDTO.email(),
                        registerDTO.cpf(),
                        registerDTO.telefone(),
                        baseRepository.findById(registerDTO.base())
                ));
                break;

            case ENTREGADOR:
                entregadorSave(new Entregador(
                        registerDTO.nome(),
                        registerDTO.email(),
                        registerDTO.cpf(),
                        registerDTO.telefone(),
                        baseRepository.findById(registerDTO.base()),
                        registerDTO.endereco()
                ));
                break;

            default:
                funcionarioSave(new Funcionario(
                        registerDTO.nome(),
                        registerDTO.email(),
                        registerDTO.cpf(),
                        registerDTO.telefone(),
                        baseRepository.findById(registerDTO.base())
                ));
                break;
        }
    }

    private void validateBase(Long baseId) {
        if (baseRepository.findById(baseId) == null) {
            throw new ErrorException("Base não cadastrada", 400);
        }
    }

    private String formatCpf(String cpf) {
        String cpfInValidate = cpf.replaceAll("[^\\d]", "");
        
        if (cpfInValidate.length() != 11) {
            return null;
        }
        
        return cpfInValidate.substring(0, 3) + "." + cpfInValidate.substring(3, 6) + "." + cpfInValidate.substring(6, 9) + "-" + cpfInValidate.substring(9);
    }

    private void validateCpfUniqueness(String cpf, Object repository) {
        if (repository instanceof IFuncionarioRepository) {
            Funcionario funcionario = funcionarioRepository.findByCpf(cpf);
            if (funcionario != null) {
                throw new ErrorException("CPF já cadastrado", 400);
            }
        } else if (repository instanceof IMotoristaRepository) {
            Motorista motorista = motoristaRepository.findByCpf(cpf);
            if (motorista != null) {
                throw new ErrorException("CPF já cadastrado", 400);
            }
        } else if (repository instanceof IEntregadorRepository) {
            Entregador entregador = entregadorRepository.findByCpf(cpf);
            if (entregador != null) {
                throw new ErrorException("CPF já cadastrado", 400);
            }
        }
    }

    private void motoristaSave(Motorista motorista) {
        motorista.setEmail(motorista.getEmail().toLowerCase());
        motorista.setCpf(formatCpf(motorista.getCpf()));
        validateCpfUniqueness(motorista.getCpf(), motoristaRepository);
        motoristaRepository.save(motorista);
    }

    private void entregadorSave(Entregador entregador) {
        entregador.setEmail(entregador.getEmail().toLowerCase());
        entregador.setCpf(formatCpf(entregador.getCpf()));
        validateCpfUniqueness(entregador.getCpf(), entregadorRepository);
        entregadorRepository.save(entregador);
    }

    private void funcionarioSave(Funcionario funcionario) {
        funcionario.setEmail(funcionario.getEmail().toLowerCase());
        funcionario.setCpf(formatCpf(funcionario.getCpf()));
        validateCpfUniqueness(funcionario.getCpf(), funcionarioRepository);
        funcionarioRepository.save(funcionario);
    }

}


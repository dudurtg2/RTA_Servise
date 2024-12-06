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
import com.example.empresa.services.CustomExceptionService;
import com.example.empresa.services.ValidacaoService;
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
        if (usersRepository.findByEmail(registerDTO.email()) != null) throw new CustomExceptionService("Email já cadastrado.", 400);
        
        switch (registerDTO.role()) {
            case MOTORISTA:  
                    motoristaSave(new Motorista(registerDTO.nome(),
                                                        registerDTO.email(),
                                                        registerDTO.cpf(),
                                                        registerDTO.telefone(),
                                                        baseRepository.findById(registerDTO.base())));
                    
                break;
            case ENTREGADOR:
                motoristaSave(new Entregador(registerDTO.nome(),
                                                            registerDTO.email(),
                                                            registerDTO.cpf(),
                                                            registerDTO.telefone(),
                                                            baseRepository.findById(registerDTO.base()),
                                                            registerDTO.endereco()));

                break;
            default:
                funcionarioSave(new Funcionario(registerDTO.nome(),
                                                            registerDTO.email(),
                                                            registerDTO.cpf(),
                                                            registerDTO.telefone(),
                                                            baseRepository.findById(registerDTO.base())));
                break;
        }
        return usersRepository.save(new Users(registerDTO.email().toLowerCase(),
                                                new BCryptPasswordEncoder().encode(registerDTO.senha()),
                                                registerDTO.role()));
    }
    

    private Entregador motoristaSave(Entregador entregador) {
        entregador.setEmail(entregador.getEmail().toLowerCase());

        if (baseRepository.findById(entregador.getBase().getId()) == null) 
            throw new CustomExceptionService("Base nao cadastrada", 400);
        

        entregador = motoristaGetCpf(entregador);

        return this.entregadorRepository.save(entregador);
    }

    private Entregador motoristaGetCpf(Entregador entregador) {
        String cpfFormatado = new ValidacaoService().Cpf(entregador.getCpf());
        if ("invalido".equals(cpfFormatado)) {
            throw new CustomExceptionService("CPF inválido", 400);
        }
        entregador.setCpf(cpfFormatado);

        Entregador cpfExistente = this.entregadorRepository.findByCpf(entregador.getCpf());
        if (cpfExistente != null && cpfExistente.getCpf().equals(entregador.getCpf())) {
            throw new CustomExceptionService("CPF já cadastrado", 400);
        }

        return entregador;
    }
    
    private Motorista motoristaSave(Motorista motorista) {
        motorista.setEmail(motorista.getEmail().toLowerCase());

        if(motoristaRepository.findByEmail(motorista.getEmail()) != null) {
            throw new CustomExceptionService("Email já cadastrado", 400);
        }

        motorista = motoristaGetCpf(motorista);
    
        return this.motoristaRepository.save(motorista);
    }
    private Motorista motoristaGetCpf(Motorista motorista) {
        String cpfFormatado = new ValidacaoService().Cpf(motorista.getCpf());
        if ("invalido".equals(cpfFormatado)) {
            throw new CustomExceptionService("CPF inválido", 400);
        }
        motorista.setCpf(cpfFormatado);
    
        Motorista cpfExistente = this.motoristaRepository.findByCpf(motorista.getCpf());
        if (cpfExistente != null && cpfExistente.getCpf().equals(motorista.getCpf())) {
            throw new CustomExceptionService("CPF já cadastrado", 400);
        }
        return motorista;
    }

    private Funcionario funcionarioSave(Funcionario funcionario) {
        funcionario.setEmail(funcionario.getEmail().toLowerCase());

        if(baseRepository.findById(funcionario.getBase().getId()) == null) throw new CustomExceptionService("Base nao cadastrada", 400);
        funcionario = funcionarioCpfExistente(funcionario);
    
        return this.funcionarioRepository.save(funcionario);
    }
    private Funcionario funcionarioCpfExistente(Funcionario funcionario) {
        String cpfFormatado = new ValidacaoService().Cpf(funcionario.getCpf());
        if ("invalido".equals(cpfFormatado)) {
            throw new CustomExceptionService("CPF inválido", 400);
        }
        funcionario.setCpf(cpfFormatado);
    
        Funcionario cpfExistente = this.funcionarioRepository.findByCpf(funcionario.getCpf());
        if (cpfExistente != null && cpfExistente.getCpf().equals(funcionario.getCpf())) {
            throw new CustomExceptionService("CPF já cadastrado", 400);
        }
        return funcionario;
    }

}




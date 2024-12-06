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

    /**
     * Realiza o cadastro de um novo usuário na base de dados.
     *
     * @param registerDTO Os dados do usuário a ser cadastrado.
     * @return A instância do usuário cadastrado.
     * @throws CustomExceptionService Se o email do usuário já estiver
     * cadastrado.
     */
    public Users save(RegisterDTO registerDTO) {
        if (usersRepository.findByEmail(registerDTO.email()) != null) {
            throw new CustomExceptionService("Email já cadastrado.", 400);
        }

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

        return usersRepository.save(new Users(
                registerDTO.email().toLowerCase(),
                new BCryptPasswordEncoder().encode(registerDTO.senha()),
                registerDTO.role()
        ));
    }

    private void validateBase(Long baseId) {
        if (baseRepository.findById(baseId) == null) {
            throw new CustomExceptionService("Base não cadastrada", 400);
        }
    }

    private String formatCpf(String cpf) {
        String cpfFormatado = new ValidacaoService().Cpf(cpf);
        if ("invalido".equals(cpfFormatado)) {
            throw new CustomExceptionService("CPF inválido", 400);
        }
        return cpfFormatado;
    }

    /**
     * Valida a unicidade de um CPF em m ltiplas implementa es de reposit rio.
     * Lan a uma exce o se o CPF j estiver cadastrado no reposit rio
     * especificado.
     *
     * @param cpf O CPF a ser verificado.
     * @param repository A inst ncia do reposit rio onde o CPF ser verificado.
     * Espera-se que seja uma das seguintes implementa es:
     * IFuncionarioRepository, IMotoristaRepository, ou IEntregadorRepository.
     * @throws CustomExceptionService se o CPF j estiver cadastrado.
     */
    private void validateCpfUniqueness(String cpf, Object repository) {
        if (repository instanceof IFuncionarioRepository) {
            Funcionario funcionario = ((IFuncionarioRepository) repository).findByCpf(cpf);
            if (funcionario != null) {
                throw new CustomExceptionService("CPF já cadastrado", 400);
            }
        } else if (repository instanceof IMotoristaRepository) {
            Motorista motorista = ((IMotoristaRepository) repository).findByCpf(cpf);
            if (motorista != null) {
                throw new CustomExceptionService("CPF já cadastrado", 400);
            }
        } else if (repository instanceof IEntregadorRepository) {
            Entregador entregador = ((IEntregadorRepository) repository).findByCpf(cpf);
            if (entregador != null) {
                throw new CustomExceptionService("CPF já cadastrado", 400);
            }
        }
    }

    /**
     * Salva uma nova inst ncia da entidade {@link Motorista}.
     *
     * @param motorista A inst ncia de {@link Motorista} a ser salva.
     */
    private void motoristaSave(Motorista motorista) {
        motorista.setEmail(motorista.getEmail().toLowerCase());
        motorista.setCpf(formatCpf(motorista.getCpf()));
        validateCpfUniqueness(motorista.getCpf(), motoristaRepository);
        motoristaRepository.save(motorista);
    }

    /**
     * Salva uma nova instância de {@link Entregador} no repositório. Garante
     * que o email seja armazenado em letras minúsculas e o CPF seja formatado.
     * Valida a unicidade do CPF antes de salvar.
     *
     * @param entregador A instância de {@link Entregador} a ser salva.
     */
    private void entregadorSave(Entregador entregador) {
        entregador.setEmail(entregador.getEmail().toLowerCase());
        entregador.setCpf(formatCpf(entregador.getCpf()));
        validateCpfUniqueness(entregador.getCpf(), entregadorRepository);
        entregadorRepository.save(entregador);
    }

    /**
     * Salva uma nova instância de {@link Funcionario} no repositório. Garante
     * que o email seja armazenado em letras minúsculas e o CPF seja formatado.
     * Valida a unicidade do CPF antes de salvar.
     *
     * @param funcionario A instância de {@link Funcionario} a ser salva.
     */
    private void funcionarioSave(Funcionario funcionario) {
        funcionario.setEmail(funcionario.getEmail().toLowerCase());
        funcionario.setCpf(formatCpf(funcionario.getCpf()));
        validateCpfUniqueness(funcionario.getCpf(), funcionarioRepository);
        funcionarioRepository.save(funcionario);
    }

}

package com.example.empresa.applications;

import java.net.Authenticator;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import com.example.empresa.entities.Entregador;
import com.example.empresa.entities.Funcionario;
import com.example.empresa.entities.Motorista;
import com.example.empresa.entities.Users;
import com.example.empresa.entities.records.DataRecord;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IEntregadorRepository;
import com.example.empresa.interfaces.IFuncionarioRepository;
import com.example.empresa.interfaces.IMotoristaRepository;
import com.example.empresa.interfaces.IUsersRepository;
import com.example.empresa.security.DTO.LoginResponseDTO;
import com.example.empresa.security.DTO.RegisterDTO;

import jakarta.persistence.EntityNotFoundException;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade
 * {@link Users}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade
 * {@link Users}.
 * Utiliza o repositório {@link IUsersRepository} para interagir com a base de
 * dados.
 */
@Component
public class UsersApplication {
    private IUsersRepository usersRepository;
    private IFuncionarioRepository funcionarioRepository;
    private IMotoristaRepository motoristaRepository;
    private IBaseRepository baseRepository;
    private IEntregadorRepository entregadorRepository;

    /**
     * Construtor da classe UsersApplication.
     * 
     * @param usersRepository O repositório para a entidade {@link Users}.
     */
    public UsersApplication(IUsersRepository usersRepository, IFuncionarioRepository funcionarioRepository,
            IMotoristaRepository motoristaRepository, IBaseRepository baseRepository,
            IEntregadorRepository entregadorRepository) {
        this.usersRepository = usersRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.motoristaRepository = motoristaRepository;
        this.baseRepository = baseRepository;
        this.entregadorRepository = entregadorRepository;
    }

    /**
     * Recupera todas as instâncias da entidade {@link Users}.
     * 
     * @return Uma lista com todas as instâncias de {@link Users}.
     */
    public List<Users> findAll() {
        return this.usersRepository.findAll();
    }

    /**
     * Recupera uma instância da entidade {@link Users} com base no seu
     * identificador único.
     * 
     * @param id O identificador da instância de {@link Users}.
     * @return A instância de {@link Users} correspondente ao id, ou null se não
     *         encontrado.
     */
    public Users findById(long id) {
        return this.usersRepository.findById(id);
    }

    /**
     * Salva um novo objeto {@link Users} no sistema.
     * O login do usuário é convertido para minúsculas antes de ser salvo.
     * Além disso, a senha é criptografada usando {@link BCryptPasswordEncoder}.
     * 
     * @param users o objeto {@link RegisterDTO} contendo as informações de registro
     *              do usuário.
     * @return o objeto {@link Users} salvo.
     */
    public Users save(RegisterDTO users) {

        

        switch (users.role()) {

            case MOTORISTA:
                if (this.saveMotorista(users) != null) {
                    return this.usersRepository.save(new Users(users.email(), new BCryptPasswordEncoder().encode(users.senha()), users.role()));
                }
                throw new EntityNotFoundException("Não foi possivel salvar o motorista.");

            case ENTREGADOR:
               
                if (this.saveEntregador(users) != null) {
                    return this.usersRepository.save(new Users(users.email(), new BCryptPasswordEncoder().encode(users.senha()), users.role()));
                }
                throw new EntityNotFoundException("Não foi possivel salvar o entregador.");

            default:
                if (this.saveFuncionario(users) != null) {
                    return this.usersRepository.save(new Users(users.email(), new BCryptPasswordEncoder().encode(users.senha()), users.role()));
                }
                throw new EntityNotFoundException("Não foi possivel salvar o funcionario.");

        }
    };

    /**
     * Salva uma nova instância da entidade {@link Entregador} no repositório e
     * persiste o usuário associado.
     *
     * @param users      O objeto {@link RegisterDTO} contendo as informações de
     *                   registro do entregador.
     * @param usersIndBD O objeto {@link Users} associado que será salvo no sistema.
     * @return O objeto {@link Users} salvo no repositório.
     */
    private Entregador saveEntregador(RegisterDTO users) {
        Entregador entregador = new Entregador(users.nome(), users.email(), users.cpf(), users.telefone(),
                baseRepository.findById(users.base()), users.endereco());

                return this.entregadorRepository.save(entregador);
         
    }

    /**
     * Salva uma nova inst ncia da entidade {@link Funcionario} no reposit rio e
     * persiste o usu rio associado.
     *
     * @param users      O objeto {@link RegisterDTO} contendo as informa es de
     *                   registro do funcion rio.
     * @param usersIndBD O objeto {@link Users} associado que ser salvo no sistema.
     * @return O objeto {@link Users} salvo no reposit rio.
     */
    private Funcionario saveFuncionario(RegisterDTO users) {
        Funcionario funcionario = new Funcionario(users.nome(), users.email(), users.cpf(), users.telefone(),
                baseRepository.findById(users.base()));

        return this.funcionarioRepository.save(funcionario);
        
    }

    /**
     * Salva uma nova instância da entidade {@link Motorista} no repositório e
     * persiste o usuário associado.
     *
     * @param users      O objeto {@link RegisterDTO} contendo as informações de
     *                   registro do motorista.
     * @param usersIndBD O objeto {@link Users} associado que será salvo no sistema.
     * @return O objeto {@link Users} salvo no repositório.
     */
    private Motorista saveMotorista(RegisterDTO users) {
        Motorista motorista = new Motorista(users.nome(), users.email(), users.cpf(), users.telefone(),
                baseRepository.findById(users.base()));

        return this.motoristaRepository.save(motorista);
        
    }


    /**
     * Atualiza uma instância existente de {@link Users}.
     * O login do usuário é convertido para minúsculas antes de ser atualizado.
     * Além disso, a senha é criptografada usando {@link BCryptPasswordEncoder}.
     * 
     * @param id    O identificador da instância a ser atualizada.
     * @param users A nova instância de {@link Users} contendo as atualizações.
     * @return A instância atualizada de {@link Users}, ou null se não encontrado.
     */
    public Users update(long id, Users users) {
        Users usersInDb = this.usersRepository.findById(id);
        if (usersInDb == null) {
            return null;
        }

        // Converte o login para minúsculas antes de salvar
        users.setLogin(users.getLogin().toLowerCase());
        // Criptografa a senha antes de atualizar
        users.setSenha(new BCryptPasswordEncoder().encode(users.getSenha()));

        return this.usersRepository.update(id, users);
    }

    /**
     * Exclui a instância da entidade {@link Users} com base no seu identificador
     * único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(long id) {
        this.usersRepository.deleteById(id);
    }

    /**
     * Recupera uma instância de {@link Funcionario}, {@link Motorista} ou
     * {@link Entregador} com base no email.
     * 
     * @param email O email da instância a ser encontrada.
     * @return A inst ncia de {@link Funcionario}, {@link Motorista} ou
     *         {@link Entregador} correspondente ao email, ou null se n o
     *         encontrado.
     */
    public <T> T findByEmail(String email) {

        Funcionario funcionario = this.funcionarioRepository.findByEmail(email);
        if (funcionario != null) {
            return (T) new DataRecord(funcionario, "Funcionario");
        }
        
        Motorista motorista = this.motoristaRepository.findByEmail(email);
        if (motorista != null) {
            return (T) new DataRecord(motorista, "Motorista");
        }

        Entregador entregador = this.entregadorRepository.findByEmail(email);
        if (entregador != null) {
            return (T) new DataRecord(entregador, "Entregador");
        }
        
        return null;
    }
    
    
}

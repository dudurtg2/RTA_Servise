package com.example.empresa.applications;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.empresa.applications.records.DataRecord;
import com.example.empresa.entities.Entregador;
import com.example.empresa.entities.Funcionario;
import com.example.empresa.entities.Motorista;
import com.example.empresa.entities.Users;
import com.example.empresa.interfaces.IEntregadorRepository;
import com.example.empresa.interfaces.IFuncionarioRepository;
import com.example.empresa.interfaces.IMotoristaRepository;
import com.example.empresa.interfaces.IUsersRepository;

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
    private IEntregadorRepository entregadorRepository;

    /**
     * Construtor da classe UsersApplication.
     * 
     * @param usersRepository O repositório para a entidade {@link Users}.
     */
    public UsersApplication(IUsersRepository usersRepository, 
                            IFuncionarioRepository funcionarioRepository,
                            IMotoristaRepository motoristaRepository,
                            IEntregadorRepository entregadorRepository) {
        this.usersRepository = usersRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.motoristaRepository = motoristaRepository;
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
    public DataRecord findByEmail(String email) {

        Users user = usersRepository.findByEmail(email);
        if (user == null) return null;

        switch (user.getRole()) {
            case MOTORISTA:
                Motorista motorista = motoristaRepository.findByEmail(email);
                return motorista != null ? new DataRecord(motorista, "MOTORISTA") : null;
    
            case ENTREGADOR:
                Entregador entregador = entregadorRepository.findByEmail(email);
                return entregador != null ? new DataRecord(entregador, "ENTREGADOR") : null;
            default:
                Funcionario funcionario = funcionarioRepository.findByEmail(email);
                return funcionario != null ? new DataRecord(funcionario, usersRepository.findByEmail(email).getRole().toString()) : null;
        }
        
    }

    /**
     * Recupera uma inst ncia de {@link Users} com base no login.
     * 
     * @param login O login da inst ncia de {@link Users}.
     * @return A inst ncia de {@link Users} correspondente ao login, ou null se n o
     *         encontrado.
     */
    public Users findByLogin(String login) {
        return this.usersRepository.findByLogin(login);
    }
    
}

package com.example.empresa.applications;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.empresa.emuns.UserRole;
import com.example.empresa.entities.Funcionario;
import com.example.empresa.entities.Motorista;
import com.example.empresa.entities.Users;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IFuncionarioRepository;
import com.example.empresa.interfaces.IMotoristaRepository;
import com.example.empresa.interfaces.IUsersRepository;
import com.example.empresa.security.DTO.RegisterDTO;

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

    /**
     * Construtor da classe UsersApplication.
     * 
     * @param usersRepository O repositório para a entidade {@link Users}.
     */
    public UsersApplication(IUsersRepository usersRepositor, IFuncionarioRepository funcionarioRepository,
            IMotoristaRepository motoristaRepository, IBaseRepository baseRepository) {
        this.usersRepository = usersRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.motoristaRepository = motoristaRepository;
        this.baseRepository = baseRepository;
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
     * Salva uma nova instância da entidade {@link Users} no repositório.
     * O login do usuário é convertido para minúsculas antes de ser salvo.
     * 
     * @param users A instância da entidade {@link Users} a ser salva.
     * @return A instância salva de {@link Users}.
     */
    
    public Users save(RegisterDTO users) {
        Users usersIndBD = new Users(users.email(), new BCryptPasswordEncoder().encode(users.senha()), users.role());
        switch (users.role()) {
            case FUNCIONARIO:
                return this.saveFuncionario(users, usersIndBD);
            case MOTORISTA:
                return this.saveMotorista(users, usersIndBD);
            default:
                return null;
           
        }
    };

    private Users saveFuncionario(RegisterDTO users, Users usersIndBD) {
        Funcionario funcionario = new Funcionario(users.nome(), users.email(), users.cpf(), users.telefone(),
                baseRepository.findById(users.base()));

        this.funcionarioRepository.save(funcionario);
        return this.usersRepository.save(usersIndBD);
    }

    private Users saveMotorista(RegisterDTO users, Users usersIndBD) {
        Motorista motorista = new Motorista(users.nome(), users.email(), users.cpf(), users.telefone(),
                baseRepository.findById(users.base()));

        this.motoristaRepository.save(motorista);
        return this.usersRepository.save(usersIndBD);
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
}

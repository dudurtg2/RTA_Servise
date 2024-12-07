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

@Component
public class UsersApplication {
    private IUsersRepository usersRepository;
    private IFuncionarioRepository funcionarioRepository;
    private IMotoristaRepository motoristaRepository;
    private IEntregadorRepository entregadorRepository;

    public UsersApplication(IUsersRepository usersRepository, 
                            IFuncionarioRepository funcionarioRepository,
                            IMotoristaRepository motoristaRepository,
                            IEntregadorRepository entregadorRepository) {
        this.usersRepository = usersRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.motoristaRepository = motoristaRepository;
        this.entregadorRepository = entregadorRepository;
    }

    public List<Users> findAll() {
        return this.usersRepository.findAll();
    }

    public Users findById(long id) {
        return this.usersRepository.findById(id);
    }

    public Users update(long id, Users users) {
        Users usersInDb = this.usersRepository.findById(id);
        if (usersInDb == null) {
            return null;
        }

        users.setLogin(users.getLogin().toLowerCase());
        users.setSenha(new BCryptPasswordEncoder().encode(users.getSenha()));

        return this.usersRepository.update(id, users);
    }

    public void deleteById(long id) {
        this.usersRepository.deleteById(id);
    }

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

    public Users findByLogin(String login) {
        return this.usersRepository.findByLogin(login);
    }
    
}


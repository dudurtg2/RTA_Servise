package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Entregador;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IEntregadorRepository;
import com.example.empresa.interfaces.IUsersRepository;
import com.example.empresa.services.ErrorException;
import com.example.empresa.services.ValidateServise;

@Component
public class EntregadorApplication {
    private IEntregadorRepository entregadorRepository;
    private IBaseRepository baseRepository;
    private ValidateServise validateServise;
    private IUsersRepository usersRepository;

    public EntregadorApplication(IEntregadorRepository entregadorRepository,IUsersRepository usersRepository, IBaseRepository baseRepository, ValidateServise validateServise) {
        this.entregadorRepository = entregadorRepository;
        this.baseRepository = baseRepository;
        this.validateServise = validateServise;
        this.usersRepository = usersRepository;
    }

    public List<Entregador> findAll() {
        
        return this.entregadorRepository.findAll().stream().filter(Entregador::isAtivo).toList();
    }

    public Entregador findById(long id) {
        return this.entregadorRepository.findById(id);
    }

    public Entregador save(Entregador entregador) {
        entregador.setEmail(entregador.getEmail().toLowerCase());   
        entregador.setAtivo(true);   
        entregador.setCpf(getCpfExistente(entregador.getCpf()));

        return this.entregadorRepository.save(entregador);
    }

    private String getCpfExistente(String cpf) {
        String cpfFormatado = validateServise.cpf(cpf);

        if (cpfFormatado.isEmpty()) throw new ErrorException("CPF inválido", 409);
        if (this.entregadorRepository.findByCpf(cpf) != null) throw new ErrorException("CPF já cadastrado", 409);
        
        return cpfFormatado;
    }


    public Entregador update(long id, Entregador entregador) {
        entregador.setEmail(entregador.getEmail().toLowerCase());

        entregador.setCpf(getCpfExistente(entregador.getCpf()));

        return this.entregadorRepository.update(id, entregador);
    }

    public void deleteById(long id) {
        Entregador entregador = this.entregadorRepository.findById(id);
        if (entregador == null) throw new ErrorException("Funcionario com id " + id + " nao encontrada.", 404);
        this.usersRepository.deleteById(this.usersRepository.findByLogin(entregador.getEmail()).getId());
        entregador.setAtivo(false);
        entregador.setEmail("DELETEUSER"+entregador.getId()+"@DELETEUSER");
        entregador.setCpf("00000000000");
        this.entregadorRepository.update(entregador.getId(), entregador);
    }

    public Entregador findByEmail(String email) {
        return this.entregadorRepository.findByEmail(email);
    }
}


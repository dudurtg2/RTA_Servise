package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Funcionario;
import com.example.empresa.interfaces.IFuncionarioRepository;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade {@link Funcionario}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade {@link Funcionario}.
 * Utiliza o repositório {@link IFuncionarioRepository} para interagir com a base de dados.
 */
@Component
public class FuncionarioApplication {
    private IFuncionarioRepository funcionarioRepository;

    /**
     * Construtor da classe FuncionarioApplication.
     * 
     * @param funcionarioRepository O repositório para a entidade {@link Funcionario}.
     */
    public FuncionarioApplication(IFuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    /**
     * Recupera todas as instâncias da entidade {@link Funcionario}.
     * 
     * @return Uma lista com todas as instâncias de {@link Funcionario}.
     */
    public List<Funcionario> findAll() {
        return this.funcionarioRepository.findAll();
    }

    /**
     * Recupera uma instância da entidade {@link Funcionario} com base no seu identificador único.
     * 
     * @param id O identificador da instância de {@link Funcionario}.
     * @return A instância de {@link Funcionario} correspondente ao id, ou null se não encontrado.
     */
    public Funcionario findById(long id) {
        return this.funcionarioRepository.findById(id);
    }
    
    /**
     * Salva uma nova instância da entidade {@link Funcionario} no repositório, garantindo que o email seja salvo em letras minúsculas.
     * 
     * @param funcionario A instância da entidade {@link Funcionario} a ser salva.
     * @return A instância salva de {@link Funcionario}.
     */
    public Funcionario save(Funcionario funcionario) {
        funcionario.setEmail(funcionario.getEmail().toLowerCase());

        return this.funcionarioRepository.save(funcionario);
    }

    /**
     * Atualiza uma instância existente de {@link Funcionario}, garantindo que o email seja salvo em letras minúsculas.
     * 
     * @param id O identificador da instância a ser atualizada.
     * @param funcionario A nova instância de {@link Funcionario} contendo as atualizações.
     * @return A instância atualizada de {@link Funcionario}, ou null se não encontrado.
     */
    public Funcionario update(long id, Funcionario funcionario) {
        Funcionario funcionarioInDb = this.funcionarioRepository.findById(id);

        if (funcionarioInDb == null) {
            return null;
        }

        funcionario.setEmail(funcionario.getEmail().toLowerCase());

        return this.funcionarioRepository.update(id, funcionario);
    }

    /**
     * Exclui a instância da entidade {@link Funcionario} com base no seu identificador único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(long id) {
        this.funcionarioRepository.deleteById(id);
    }
}

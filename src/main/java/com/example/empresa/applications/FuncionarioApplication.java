package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Funcionario;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IFuncionarioRepository;
import com.example.empresa.services.CustomExceptionService;
import com.example.empresa.services.ValidacaoService;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade {@link Funcionario}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade {@link Funcionario}.
 * Utiliza o repositório {@link IFuncionarioRepository} para interagir com a base de dados.
 */
@Component
public class FuncionarioApplication {
    private IFuncionarioRepository funcionarioRepository;
    private IBaseRepository baseRepository;

    /**
     * Construtor da classe FuncionarioApplication.
     * 
     * @param funcionarioRepository O repositório para a entidade {@link Funcionario}.
     */
    public FuncionarioApplication(IFuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
        this.baseRepository = baseRepository;
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

        if(baseRepository.findById(funcionario.getBase().getId()) == null) throw new CustomExceptionService("Base nao cadastrada", 400);
        funcionario = getCpfExistente(funcionario);
    
        return this.funcionarioRepository.save(funcionario);
    }

    /**
     * Verifica se o CPF do objeto {@link Funcionario} existe no repositório,
     * e lança uma exceção caso:
     * <ul>
     * <li>O CPF seja inválido;</li>
     * <li>O CPF já esteja cadastrado.</li>
     * </ul>
     * 
     * @param funcionario A inst ncia de {@link Funcionario} a ser verificada.
     * @return A inst ncia de {@link Funcionario} verificada.
     */
    private Funcionario getCpfExistente(Funcionario funcionario) {
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
    

    /**
     * Atualiza uma instância existente de {@link Funcionario}, garantindo que o email seja salvo em letras minúsculas.
     * 
     * @param id O identificador da instância a ser atualizada.
     * @param funcionario A nova instância de {@link Funcionario} contendo as atualizações.
     * @return A instância atualizada de {@link Funcionario}, ou null se não encontrado.
     */
    public Funcionario update(long id, Funcionario funcionario) {
        funcionario.setEmail(funcionario.getEmail().toLowerCase());

        funcionario = getCpfExistente(funcionario);

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

    /**
     * Retorna uma inst ncia de {@link Funcionario} com base no email,
     * garantindo que o email seja salvo em letras min ssculas.
     * 
     * @param email O email da inst ncia de {@link Funcionario} a ser encontrado.
     * @return A inst ncia de {@link Funcionario} correspondente ao email, ou
     *         null se n o encontrado.
     */
    public Funcionario findByEmail(String email) {
        return this.funcionarioRepository.findByEmail(email);
    }
}

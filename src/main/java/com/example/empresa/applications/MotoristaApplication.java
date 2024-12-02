package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Motorista;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IMotoristaRepository;
import com.example.empresa.services.CustomExceptionService;
import com.example.empresa.services.ValidacaoService;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade {@link Motorista}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade {@link Motorista}.
 * Utiliza o repositório {@link IMotoristaRepository} para interagir com a base de dados.
 */
@Component
public class MotoristaApplication {
    private IMotoristaRepository motoristaRepository;
    private IBaseRepository baseRepository;
    /**
     * Construtor da classe MotoristaApplication.
     * 
     * @param motoristaRepository O repositório para a entidade {@link Motorista}.
     */
    public MotoristaApplication(IMotoristaRepository motoristaRepository) {
        this.motoristaRepository = motoristaRepository;
    }
    
    /**
     * Recupera todas as instâncias da entidade {@link Motorista}.
     * 
     * @return Uma lista com todas as instâncias de {@link Motorista}.
     */
    public List<Motorista> findAll() {
        return this.motoristaRepository.findAll();
    }

    /**
     * Recupera uma instância da entidade {@link Motorista} com base no seu identificador único.
     * 
     * @param id O identificador da instância de {@link Motorista}.
     * @return A instância de {@link Motorista} correspondente ao id, ou null se não encontrado.
     */
    public Motorista findById(long id) {
        return this.motoristaRepository.findById(id);
    }

    
    /**
     * Salva uma nova inst ncia da entidade {@link Motorista}.
     * 
     * @param motorista A inst ncia de {@link Motorista} a ser salva.
     * @return A inst ncia de {@link Motorista} salva.
     * @throws CustomExceptionService Se o CPF for inv lido ou j  cadastrado.
     */
    public Motorista save(Motorista motorista) {
        motorista.setEmail(motorista.getEmail().toLowerCase());

        if(motoristaRepository.findByEmail(motorista.getEmail()) != null) {
            throw new CustomExceptionService("Email já cadastrado", 400);
        }

        motorista = getCpfExistente(motorista);
    
        return this.motoristaRepository.save(motorista);
    }

    /**
     * Verifica se o CPF do objeto {@link Motorista} existe no repositório,
     * e lan a uma exce o caso:
     * <ul>
     * <li>O CPF seja inv lido;</li>
     * <li>O CPF j  esteja cadastrado.</li>
     * </ul>
     * 
     * @param motorista A inst ncia de {@link Motorista} a ser verificada.
     * @return A inst ncia de {@link Motorista} verificada.
     * @throws CustomExceptionService Caso o CPF seja inv lido ou j  cadastrado.
     */
    private Motorista getCpfExistente(Motorista motorista) {
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

    /**
     * Atualiza uma instância existente de {@link Motorista}.
     * 
     * @param id O identificador da instância a ser atualizada.
     * @param motorista A nova instância de {@link Motorista} contendo as atualizações.
     * @return A instância atualizada de {@link Motorista}, ou null se não encontrado.
     */
    public Motorista update(long id, Motorista motorista) {
        motorista.setEmail(motorista.getEmail().toLowerCase());

        motorista = getCpfExistente(motorista);

        return this.motoristaRepository.update(id, motorista);
    }

    /**
     * Exclui a instância da entidade {@link Motorista} com base no seu identificador único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(long id) {
        this.motoristaRepository.deleteById(id);
    }

    /**
     * Recupera uma inst ncia da entidade {@link Motorista} com base no email.
     * 
     * @param email O email da inst ncia de {@link Motorista}.
     * @return A inst ncia de {@link Motorista} correspondente ao email, ou null se n o
     *         encontrado.
     */
    public Motorista findByEmail(String email) {
        return this.motoristaRepository.findByEmail(email);
    }

}

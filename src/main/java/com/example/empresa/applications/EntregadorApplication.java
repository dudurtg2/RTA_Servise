package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Entregador;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IEntregadorRepository;
import com.example.empresa.services.CustomExceptionService;
import com.example.empresa.services.ValidacaoService;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade
 * {@link Entregador}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade
 * {@link Entregador}.
 * Utiliza o repositório {@link IEntregadorRepository} para interagir com a base
 * de dados.
 */
@Component
public class EntregadorApplication {
    private IEntregadorRepository entregadorRepository;
    private IBaseRepository baseRepository;

    /**
     * Construtor da classe EntregadorApplication.
     * 
     * @param entregadorRepository O repositório para a entidade {@link Entregador}.
     */
    public EntregadorApplication(IEntregadorRepository entregadorRepository, IBaseRepository baseRepository) {
        this.entregadorRepository = entregadorRepository;
        this.baseRepository = baseRepository;
    }

    /**
     * Recupera todas as instâncias da entidade {@link Entregador}.
     * 
     * @return Uma lista com todas as instâncias de {@link Entregador}.
     */
    public List<Entregador> findAll() {
        return this.entregadorRepository.findAll();
    }

    /**
     * Recupera uma instância da entidade {@link Entregador} com base no seu
     * identificador único.
     * 
     * @param id O identificador da instância de {@link Entregador}.
     * @return A instância de {@link Entregador} correspondente ao id, ou null se
     *         não encontrado.
     */
    public Entregador findById(long id) {
        return this.entregadorRepository.findById(id);
    }

    /**
     * Salva uma instância da entidade {@link Entregador}.
     * 
     * @param entregador A instância de {@link Entregador} a ser salva.
     * @return A instância de {@link Entregador} salva, ou lança uma exceção caso:
     *         <ul>
     *         <li>O CPF seja inválido;</li>
     *         <li>O CPF já esteja cadastrado.</li>
     *         </ul>
     */
    public Entregador save(Entregador entregador) {
        entregador.setEmail(entregador.getEmail().toLowerCase());

        if (baseRepository.findById(entregador.getBase().getId()) == null) {
            throw new CustomExceptionService("Base nao cadastrada", 400);
        }

        entregador = getCpfExistente(entregador);

        return this.entregadorRepository.save(entregador);
    }

    /**
     * Verifica se o CPF do objeto {@link Entregador} existe no repositório,
     * e lança uma exceção caso:
     * <ul>
     * <li>O CPF seja inválido;</li>
     * <li>O CPF já esteja cadastrado.</li>
     * </ul>
     * 
     * @param entregador A instância de {@link Entregador} a ser verificada.
     */
    private Entregador getCpfExistente(Entregador entregador) {
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

    /**
     * Atualiza uma instância existente de {@link Entregador}, garantindo que o
     * email seja salvo em letras minúsculas.
     * 
     * @param id         O identificador da instância a ser atualizada.
     * @param entregador A nova instância de {@link Entregador} contendo as
     *                   atualizações.
     * @return A instância atualizada de {@link Entregador}, ou null se não
     *         encontrado.
     */
    public Entregador update(long id, Entregador entregador) {
        entregador.setEmail(entregador.getEmail().toLowerCase());

        entregador = getCpfExistente(entregador);

        return this.entregadorRepository.update(id, entregador);
    }

    /**
     * Exclui a instância da entidade {@link Entregador} com base no seu
     * identificador único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(long id) {
        this.entregadorRepository.deleteById(id);
    }

    /**
     * Recupera uma instância de {@link Entregador} com base no seu email.
     * 
     * @param email O email da instância de {@link Entregador}.
     * @return A instância de {@link Entregador} correspondente ao email, ou null se
     *         não encontrado.
     */
    public Entregador findByEmail(String email) {
        return this.entregadorRepository.findByEmail(email);
    }
}

package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Motorista;
import com.example.empresa.interfaces.IMotoristaRepository;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade {@link Motorista}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade {@link Motorista}.
 * Utiliza o repositório {@link IMotoristaRepository} para interagir com a base de dados.
 */
@Component
public class MotoristaApplication {
    private IMotoristaRepository motoristaRepository;
    
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
     * Salva uma nova instância da entidade {@link Motorista} no repositório.
     * 
     * @param motorista A instância da entidade {@link Motorista} a ser salva.
     * @return A instância salva de {@link Motorista}.
     */
    public Motorista save(Motorista motorista) {
        return this.motoristaRepository.save(motorista);
    }

    /**
     * Atualiza uma instância existente de {@link Motorista}.
     * 
     * @param id O identificador da instância a ser atualizada.
     * @param motorista A nova instância de {@link Motorista} contendo as atualizações.
     * @return A instância atualizada de {@link Motorista}, ou null se não encontrado.
     */
    public Motorista update(long id, Motorista motorista) {
        Motorista motoristaInDb = this.motoristaRepository.findById(id);

        if (motoristaInDb == null) {
            return null;
        }

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
}

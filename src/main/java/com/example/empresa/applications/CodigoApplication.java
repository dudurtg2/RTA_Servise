package com.example.empresa.applications;

import com.example.empresa.entities.Codigo;
import com.example.empresa.interfaces.ICodigoRepository;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade {@link Codigo}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade {@link Codigo}.
 * Utiliza o repositório {@link ICodigoRepository} para interagir com a base de dados.
 */
@Component
public class CodigoApplication {
    
    private ICodigoRepository codigoRepository;

    /**
     * Construtor da classe CodigoApplication.
     * 
     * @param codigoRepository O repositório para a entidade {@link Codigo}.
     */
    public CodigoApplication(ICodigoRepository codigoRepository) {
        this.codigoRepository = codigoRepository;
    }

    /**
     * Recupera todas as instâncias da entidade {@link Codigo}.
     * 
     * @return Uma lista com todas as instâncias de {@link Codigo}.
     */
    public List<Codigo> findAll() {
        return this.codigoRepository.findAll();
    }

    /**
     * Recupera uma instância da entidade {@link Codigo} com base no seu identificador único.
     * 
     * @param id O identificador da instância de {@link Codigo}.
     * @return A instância de {@link Codigo} correspondente ao id, ou null se não encontrado.
     */
    public Codigo findById(long id) {
        return this.codigoRepository.findById(id);
    }

    /**
     * Salva uma nova instância da entidade {@link Codigo} no repositório.
     * 
     * @param codigo A instância da entidade {@link Codigo} a ser salva.
     * @return A instância salva de {@link Codigo}.
     */
    public Codigo save(Codigo codigo) {
        return this.codigoRepository.save(codigo);
    }

    /**
     * Atualiza uma instância existente de {@link Codigo}.
     * 
     * @param id O identificador da instância a ser atualizada.
     * @param codigo A nova instância de {@link Codigo} contendo as atualizações.
     * @return A instância atualizada de {@link Codigo}, ou null se não encontrado.
     */
    public Codigo update(long id, Codigo codigo) {
        return this.codigoRepository.update(id, codigo);
    }

    /**
     * Exclui a instância da entidade {@link Codigo} com base no seu identificador único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(long id) {
        this.codigoRepository.deleteById(id);
    }
}

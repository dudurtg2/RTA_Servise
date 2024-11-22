package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Entregador;
import com.example.empresa.interfaces.IEntregadorRepository;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade {@link Entregador}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade {@link Entregador}.
 * Utiliza o repositório {@link IEntregadorRepository} para interagir com a base de dados.
 */
@Component
public class EntregadorApplication {
    private IEntregadorRepository entregadorRepository;

    /**
     * Construtor da classe EntregadorApplication.
     * 
     * @param entregadorRepository O repositório para a entidade {@link Entregador}.
     */
    public EntregadorApplication(IEntregadorRepository entregadorRepository) {
        this.entregadorRepository = entregadorRepository;
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
     * Recupera uma instância da entidade {@link Entregador} com base no seu identificador único.
     * 
     * @param id O identificador da instância de {@link Entregador}.
     * @return A instância de {@link Entregador} correspondente ao id, ou null se não encontrado.
     */
    public Entregador findById(int id) {
        return this.entregadorRepository.findById(id);
    }

    /**
     * Salva uma nova instância da entidade {@link Entregador} no repositório, garantindo que o email seja salvo em letras minúsculas.
     * 
     * @param entregador A instância da entidade {@link Entregador} a ser salva.
     * @return A instância salva de {@link Entregador}.
     */
    public Entregador save(Entregador entregador) {
        entregador.setEmail(entregador.getEmail().toLowerCase());
        return this.entregadorRepository.save(entregador);
    }

    /**
     * Atualiza uma instância existente de {@link Entregador}, garantindo que o email seja salvo em letras minúsculas.
     * 
     * @param id O identificador da instância a ser atualizada.
     * @param entregador A nova instância de {@link Entregador} contendo as atualizações.
     * @return A instância atualizada de {@link Entregador}, ou null se não encontrado.
     */
    public Entregador update(int id, Entregador entregador) {
        Entregador entregadorInDb = this.entregadorRepository.findById(id);
        
        if (entregadorInDb == null) {
            return null;
        }
        
        entregador.setEmail(entregador.getEmail().toLowerCase());

        return this.entregadorRepository.update(id, entregador);
    }

    /**
     * Exclui a instância da entidade {@link Entregador} com base no seu identificador único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(int id) {
        this.entregadorRepository.deleteById(id);
    }
}

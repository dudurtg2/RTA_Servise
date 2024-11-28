package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Base;
import com.example.empresa.interfaces.IBaseRepository;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade {@link Base}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade {@link Base}.
 * Utiliza o repositório {@link IBaseRepository} para interagir com a base de dados.
 */
@Component
public class BaseApplication {

    private IBaseRepository baseRepository;

    /**
     * Construtor da classe BaseApplication.
     * 
     * @param baseRepository O repositório para a entidade {@link Base}.
     */
    public BaseApplication(IBaseRepository baseRepository) {
        this.baseRepository = baseRepository;
    }

    /**
     * Recupera todas as instâncias da entidade {@link Base}.
     * 
     * @return Uma lista com todas as instâncias de {@link Base}.
     */
    public List<Base> findAll() {
        return this.baseRepository.findAll();
    }

    /**
     * Recupera uma instância da entidade {@link Base} com base no seu identificador único.
     * 
     * @param id O identificador da instância de {@link Base}.
     * @return A instância de {@link Base} correspondente ao id, ou null se não encontrado.
     */
    public Base findById(long id) {
        return this.baseRepository.findById(id);
    }

    /**
     * Salva uma nova instância da entidade {@link Base} no repositório.
     * 
     * @param base A instância da entidade {@link Base} a ser salva.
     * @return A instância salva de {@link Base}.
     */
    public Base save(Base base) {
        return this.baseRepository.save(base);
    }

    /**
     * Atualiza uma instância existente de {@link Base}.
     * 
     * @param id O identificador da instância a ser atualizada.
     * @param base A nova instância de {@link Base} contendo as atualizações.
     * @return A instância atualizada de {@link Base}, ou null se não encontrado.
     */
    public Base update(long id, Base base) {
        Base baseInDb = this.baseRepository.findById(id);
        
        if (baseInDb == null) {
            return null;
        }

        return this.baseRepository.update(id, base);
    }
    
    /**
     * Exclui a instância da entidade {@link Base} com base no seu identificador único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(long id) {
        this.baseRepository.deleteById(id);
    }
}

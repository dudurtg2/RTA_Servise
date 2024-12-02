package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Regiao;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.IRegiaoRepository;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade
 * {@link Regiao}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade
 * {@link Regiao}.
 * Utiliza o repositório {@link IRegiaoRepository} para interagir com a base de
 * dados.
 */
@Component
public class RegiaoApplication {
    private IRegiaoRepository regiaoRepository;
    private IBaseRepository baseRepository;

    /**
     * Construtor da classe RegiaoApplication.
     * 
     * @param regiaoRepository O repositório para a entidade {@link Regiao}.
     */
    public RegiaoApplication(IRegiaoRepository regiaoRepository) {
        this.regiaoRepository = regiaoRepository;
    }

    /**
     * Recupera todas as instâncias da entidade {@link Regiao}.
     * 
     * @return Uma lista com todas as instâncias de {@link Regiao}.
     */
    public List<Regiao> findAll() {
        return this.regiaoRepository.findAll();
    }

    /**
     * Recupera uma instância da entidade {@link Regiao} com base no seu
     * identificador único.
     * 
     * @param id O identificador da instância de {@link Regiao}.
     * @return A instância de {@link Regiao} correspondente ao id, ou null se não
     *         encontrado.
     */
    public Regiao findById(long id) {
        return this.regiaoRepository.findById(id);
    }

    /**
     * Salva uma nova instância da entidade {@link Regiao} no repositório.
     * 
     * @param regiao A instância da entidade {@link Regiao} a ser salva.
     * @return A instância salva de {@link Regiao}.
     */
    public Regiao save(Regiao regiao) {
        if (baseRepository.findById(regiao.getBase().getId()) == null) throw new IllegalArgumentException("Base nao encontrada");
        return this.regiaoRepository.save(regiao);

    }

    /**
     * Atualiza uma instância existente de {@link Regiao}.
     * 
     * @param id     O identificador da instância a ser atualizada.
     * @param regiao A nova instância de {@link Regiao} contendo as atualizações.
     * @return A instância atualizada de {@link Regiao}, ou null se não encontrado.
     */
    public Regiao update(long id, Regiao regiao) {
        Regiao regiaoInDb = this.regiaoRepository.findById(id);

        if (regiaoInDb == null) {
            return null;
        }
        return this.regiaoRepository.update(id, regiao);
    }

    /**
     * Exclui a instância da entidade {@link Regiao} com base no seu identificador
     * único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(long id) {
        this.regiaoRepository.deleteById(id);
    }
}

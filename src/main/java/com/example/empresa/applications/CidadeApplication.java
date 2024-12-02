package com.example.empresa.applications;

import java.util.List;

import org.aspectj.asm.IRelationship;
import org.springframework.stereotype.Component;

import com.example.empresa.entities.Cidade;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.ICidadeRepository;
import com.example.empresa.interfaces.IRegiaoRepository;
import com.example.empresa.services.CustomExceptionService;
import com.example.empresa.services.ValidacaoService;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade {@link Cidade}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade {@link Cidade}.
 * Utiliza o repositório {@link ICidadeRepository} para interagir com a base de dados.
 */
@Component
public class CidadeApplication {
    private ICidadeRepository cidadeRepository;
    private IRegiaoRepository regiaoRepository;

    /**
     * Construtor da classe CidadeApplication.
     * 
     * @param cidadeRepository O repositório para a entidade {@link Cidade}.
     */
    public CidadeApplication(ICidadeRepository cidadeRepository, IRegiaoRepository regiaoRepository) {
        this.cidadeRepository = cidadeRepository;
        this.regiaoRepository = regiaoRepository;
    }

    /**
     * Recupera todas as instâncias da entidade {@link Cidade}.
     * 
     * @return Uma lista com todas as instâncias de {@link Cidade}.
     */
    public List<Cidade> findAll() {
        return this.cidadeRepository.findAll();
    }

    /**
     * Recupera uma instância da entidade {@link Cidade} com base no seu identificador único.
     * 
     * @param id O identificador da instância de {@link Cidade}.
     * @return A instância de {@link Cidade} correspondente ao id, ou null se não encontrado.
     */
    public Cidade findById(long id) {
        return this.cidadeRepository.findById(id);
    }

    /**
     * Salva uma nova instância da entidade {@link Cidade} no repositório após validar o CEP.
     * 
     * Se o CEP fornecido for inválido, o método retorna null.
     * 
     * @param cidade A instância da entidade {@link Cidade} a ser salva.
     * @return A instância salva de {@link Cidade}, ou null se o CEP for inválido.
     */
    public Cidade save(Cidade cidade) {
        cidade.setCep(new ValidacaoService().Cep(cidade.getCep()));

        if (cidade.getCep() == null) throw new CustomExceptionService("Cep invalido", 400);
        if (regiaoRepository.findById(cidade.getRegiao().getId()) == null) throw new CustomExceptionService("Região nao encontrada", 400);

        return this.cidadeRepository.save(cidade);
    }

    /**
     * Atualiza uma instância existente de {@link Cidade} após validar o CEP.
     * 
     * Se o CEP fornecido for inválido, o método retorna null.
     * 
     * @param id O identificador da instância a ser atualizada.
     * @param cidade A nova instância de {@link Cidade} contendo as atualizações.
     * @return A instância atualizada de {@link Cidade}, ou null se não encontrado ou o CEP for inválido.
     */
    public Cidade update(long id, Cidade cidade) {
        cidade.setCep(new ValidacaoService().Cep(cidade.getCep()));

        if (cidade.getCep() == null) throw new CustomExceptionService("Cep invalido", 400);

        return this.cidadeRepository.update(id, cidade);
    }

    /**
     * Exclui a instância da entidade {@link Cidade} com base no seu identificador único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(long id) {
        this.cidadeRepository.deleteById(id);
    }
}

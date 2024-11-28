package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Cidade;
import com.example.empresa.interfaces.ICidadeRepository;
import com.example.empresa.services.ValidacaoService;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade {@link Cidade}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade {@link Cidade}.
 * Utiliza o repositório {@link ICidadeRepository} para interagir com a base de dados.
 */
@Component
public class CidadeApplication {
    private ICidadeRepository cidadeRepository;

    /**
     * Construtor da classe CidadeApplication.
     * 
     * @param cidadeRepository O repositório para a entidade {@link Cidade}.
     */
    public CidadeApplication(ICidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
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

        if (cidade.getCep().equals("invalido")) {
            return null;
        }

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
        Cidade cidadeInDb = this.cidadeRepository.findById(id);

        if (cidadeInDb == null) {
            return null;
        }

        cidade.setCep(new ValidacaoService().Cep(cidade.getCep()));

        if (cidade.getCep().equals("invalido")) {
            return null;
        }

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

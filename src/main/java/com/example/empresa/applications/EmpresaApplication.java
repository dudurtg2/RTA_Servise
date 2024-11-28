package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Empresa;
import com.example.empresa.interfaces.IEmpresaRepository;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade {@link Empresa}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade {@link Empresa}.
 * Utiliza o repositório {@link IEmpresaRepository} para interagir com a base de dados.
 */
@Component
public class EmpresaApplication {
    
    private IEmpresaRepository empresaRepository;

    /**
     * Construtor da classe EmpresaApplication.
     * 
     * @param empresaRepository O repositório para a entidade {@link Empresa}.
     */
    public EmpresaApplication(IEmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }
    
    /**
     * Recupera todas as instâncias da entidade {@link Empresa}.
     * 
     * @return Uma lista com todas as instâncias de {@link Empresa}.
     */
    public List<Empresa> findAll() {
        return this.empresaRepository.findAll();
    }

    /**
     * Recupera uma instância da entidade {@link Empresa} com base no seu identificador único.
     * 
     * @param id O identificador da instância de {@link Empresa}.
     * @return A instância de {@link Empresa} correspondente ao id, ou null se não encontrado.
     */
    public Empresa findById(long id) {
        return this.empresaRepository.findById(id);
    }

    /**
     * Salva uma nova instância da entidade {@link Empresa} no repositório.
     * 
     * @param empresa A instância da entidade {@link Empresa} a ser salva.
     * @return A instância salva de {@link Empresa}.
     */
    public Empresa save(Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }

    /**
     * Atualiza uma instância existente de {@link Empresa}.
     * 
     * @param id O identificador da instância a ser atualizada.
     * @param empresa A nova instância de {@link Empresa} contendo as atualizações.
     * @return A instância atualizada de {@link Empresa}, ou null se não encontrado.
     */
    public Empresa update(long id, Empresa empresa) {
        Empresa empresaInDb = this.empresaRepository.findById(id);

        if (empresaInDb == null) {
            return null;
        }

        return this.empresaRepository.update(id, empresa);
    }

    /**
     * Exclui a instância da entidade {@link Empresa} com base no seu identificador único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(long id) {
        this.empresaRepository.deleteById(id);
    }
}

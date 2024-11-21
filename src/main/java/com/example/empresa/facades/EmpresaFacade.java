package com.example.empresa.facades;

import com.example.empresa.applications.EmpresaApplication;
import com.example.empresa.entities.Empresa;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Fachada responsável pela lógica de negócios e pela mediação das operações de persistência
 * entre a camada de controle e a camada de aplicação para a entidade {@link Empresa}.
 * Através dessa fachada, são realizadas as operações de CRUD (Create, Read, Update, Delete)
 * para a entidade {@link Empresa}.
 */
@Component
public class EmpresaFacade {

    private final EmpresaApplication empresaApplication;

    /**
     * Construtor para injeção de dependência da {@link EmpresaApplication}.
     *
     * @param empresaApplication a aplicação que gerencia a lógica de negócios para a entidade {@link Empresa}.
     */
    public EmpresaFacade(EmpresaApplication empresaApplication) {
        this.empresaApplication = empresaApplication;
    }

    /**
     * Retorna a lista de todas as empresas armazenadas no sistema.
     *
     * @return uma lista de objetos {@link Empresa}.
     */
    public List<Empresa> findAll() {
        return this.empresaApplication.findAll();
    }

    /**
     * Retorna um objeto {@link Empresa} com base no seu identificador único.
     *
     * @param id o identificador único da empresa a ser encontrada.
     * @return o objeto {@link Empresa} correspondente ao identificador fornecido ou {@code null} se não encontrado.
     */
    public Empresa findById(int id) {
        return this.empresaApplication.findById(id);
    }

    /**
     * Salva um novo objeto {@link Empresa} no sistema.
     *
     * @param empresa o objeto {@link Empresa} a ser salvo.
     * @return o objeto {@link Empresa} que foi salvo.
     */
    public Empresa save(Empresa empresa) {
        return this.empresaApplication.save(empresa);
    }

    /**
     * Atualiza um objeto {@link Empresa} existente no sistema.
     *
     * @param id o identificador único da empresa a ser atualizada.
     * @param empresa o objeto {@link Empresa} com os novos dados a serem atualizados.
     * @return o objeto {@link Empresa} atualizado ou {@code null} caso o identificador não seja encontrado.
     */
    public Empresa update(int id, Empresa empresa) {
        return this.empresaApplication.update(id, empresa);
    }

    /**
     * Exclui um objeto {@link Empresa} com base no seu identificador único.
     *
     * @param id o identificador único da empresa a ser excluída.
     */
    public void deleteById(int id) {
        this.empresaApplication.deleteById(id);
    }
}

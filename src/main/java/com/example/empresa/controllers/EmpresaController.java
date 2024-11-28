package com.example.empresa.controllers;

import com.example.empresa.entities.Empresa;
import com.example.empresa.facades.EmpresaFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * Controlador REST para gerenciar operações relacionadas à entidade {@link Empresa}.
 * Permite realizar operações de CRUD (Create, Read, Update, Delete) sobre as empresas.
 */
@RestController
@RequestScope
@RequestMapping("/api/empresas")
public class EmpresaController {

    private EmpresaFacade empresaFacade;

    /**
     * Construtor para injeção de dependência do {@link EmpresaFacade}.
     *
     * @param empresaFacade a fachada que gerencia a lógica de negócios para a entidade {@link Empresa}.
     */
    @Autowired
    public EmpresaController(EmpresaFacade empresaFacade) {
        this.empresaFacade = empresaFacade;
    }

    /**
     * Retorna a lista de todas as empresas.
     *
     * @return uma resposta HTTP contendo a lista de objetos {@link Empresa} e o status HTTP 200 (OK).
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<Empresa>> findAll() {
        List<Empresa> empresas = this.empresaFacade.findAll();
        return new ResponseEntity<>(empresas, HttpStatus.OK);
    }

    /**
     * Retorna uma empresa com base no seu identificador único.
     *
     * @param id o identificador único da empresa a ser encontrada.
     * @return uma resposta HTTP contendo o objeto {@link Empresa} correspondente e o status HTTP 200 (OK).
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<Empresa> findById(@PathVariable int id) {
        Empresa empresa = this.empresaFacade.findById(id);
        return new ResponseEntity<>(empresa, HttpStatus.OK);
    }

    /**
     * Salva uma nova empresa no sistema.
     *
     * @param empresa o objeto {@link Empresa} a ser salvo.
     * @return uma resposta HTTP contendo o objeto salvo e o status HTTP 201 (Created),
     * ou o status HTTP 409 (Conflict) caso ocorra um problema de integridade de dados.
     */
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Empresa empresa) {
        try {
            Empresa empresaSaved = empresaFacade.save(empresa);
            return new ResponseEntity<>(empresaSaved, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
    }

    /**
     * Atualiza uma empresa existente com base no seu identificador.
     *
     * @param id      o identificador único da empresa a ser atualizada.
     * @param empresa os novos dados da empresa.
     * @return uma resposta HTTP contendo o objeto atualizado e o status HTTP 200 (OK),
     * ou 404 (Not Found) caso o ID não seja encontrado.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Empresa> update(@PathVariable int id, @RequestBody Empresa empresa) {
        Empresa empresaUpdated = empresaFacade.update(id, empresa);
        if (empresaUpdated == null) {
            return new ResponseEntity<>(empresaUpdated, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(empresaUpdated, HttpStatus.OK);
    }

    /**
     * Exclui uma empresa com base no seu identificador único.
     *
     * @param id o identificador único da empresa a ser excluída.
     * @return uma resposta HTTP com o status 200 (OK).
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        empresaFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

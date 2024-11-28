package com.example.empresa.controllers;

import com.example.empresa.entities.Funcionario;
import com.example.empresa.facades.FuncionarioFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;

/**
 * Controlador REST para gerenciar operações relacionadas à entidade {@link Funcionario}.
 * Permite realizar operações de CRUD (Create, Read, Update, Delete) sobre os funcionários.
 */
@RestController
@RequestScope
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    private FuncionarioFacade funcionarioFacade;

    /**
     * Construtor para injeção de dependência do {@link FuncionarioFacade}.
     *
     * @param funcionarioFacade a fachada que gerencia a lógica de negócios para a entidade {@link Funcionario}.
     */
    @Autowired
    public FuncionarioController(FuncionarioFacade funcionarioFacade) {
        this.funcionarioFacade = funcionarioFacade;
    }

    /**
     * Retorna a lista de todos os funcionários.
     *
     * @return uma resposta HTTP contendo a lista de objetos {@link Funcionario} e o status HTTP 200 (OK).
     */
    @GetMapping("/findAll")
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> funcionarios = this.funcionarioFacade.findAll();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    /**
     * Retorna um funcionário com base no seu identificador único.
     *
     * @param id o identificador único do funcionário a ser encontrado.
     * @return uma resposta HTTP contendo o objeto {@link Funcionario} correspondente e o status HTTP 200 (OK).
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable long id) {
        Funcionario funcionario = this.funcionarioFacade.findById(id);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    /**
     * Salva um novo funcionário no sistema.
     *
     * @param funcionario o objeto {@link Funcionario} a ser salvo.
     * @return uma resposta HTTP contendo o objeto salvo e o status HTTP 201 (Created),
     * ou o status HTTP 409 (Conflict) caso ocorra um problema de integridade de dados.
     */
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Funcionario funcionario) {
        try {
            Funcionario funcionarioSaved = funcionarioFacade.save(funcionario);
            return new ResponseEntity<>(funcionarioSaved, HttpStatus.CREATED);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(false, HttpStatus.CONFLICT);
        }
    }

    /**
     * Atualiza um funcionário existente com base no seu identificador.
     *
     * @param id         o identificador único do funcionário a ser atualizado.
     * @param funcionario os novos dados do funcionário.
     * @return uma resposta HTTP contendo o objeto atualizado e o status HTTP 200 (OK),
     * ou 404 (Not Found) caso o ID não seja encontrado.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Funcionario> update(@PathVariable long id, @RequestBody Funcionario funcionario) {
        Funcionario funcionarioUpdated = funcionarioFacade.update(id, funcionario);
        if (funcionarioUpdated == null) {
            return new ResponseEntity<>(funcionarioUpdated, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(funcionarioUpdated, HttpStatus.OK);
    }

    /**
     * Exclui um funcionário com base no seu identificador único.
     *
     * @param id o identificador único do funcionário a ser excluído.
     * @return uma resposta HTTP com o status 200 (OK).
     */
    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        funcionarioFacade.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

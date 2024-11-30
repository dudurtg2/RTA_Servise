package com.example.empresa.controllers;

import com.example.empresa.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empresa.entities.Users;
import com.example.empresa.facades.FuncionarioFacade;
import com.example.empresa.facades.UsersFacade;
import com.example.empresa.security.DTO.AuthorizationDTO;
import com.example.empresa.security.DTO.LoginResponseDTO;
import com.example.empresa.security.DTO.RegisterDTO;

/**
 * Controlador responsável pelas operações de autenticação e registro de usuários no sistema.
 * Possui endpoints para login e registro de novos usuários.
 */
@RestController
@RequestMapping("/auth")
public class UsersController {

    private final AuthenticationManager authenticationManager;
    private UsersFacade usersFacade;
    private final TokenService tokenService;

    /**
     * Construtor para injeção das dependências necessárias para o controle de autenticação.
     *
     * @param tokenService o serviço responsável pela geração do token de autenticação.
     * @param authenticationManager o gerenciador de autenticação para validar credenciais.
     * @param usersFacade a fachada que gerencia as operações de CRUD sobre a entidade {@link Users}.
     */
    @Autowired
    public UsersController(TokenService tokenService, AuthenticationManager authenticationManager, UsersFacade usersFacade) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.usersFacade = usersFacade;
    }

    /**
     * Endpoint responsável por realizar o login de um usuário no sistema.
     * Recebe as credenciais (login e senha), valida-as e retorna um token de autenticação.
     *
     * @param data os dados de login do usuário ({@link AuthorizationDTO} contendo login e senha).
     * @return uma resposta HTTP com o token gerado para autenticação.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthorizationDTO data) {
        try {
            var usernamePass = new UsernamePasswordAuthenticationToken(data.login().toLowerCase(), data.senha());
            var auth = this.authenticationManager.authenticate(usernamePass);

            var token = tokenService.generateToken((Users) auth.getPrincipal());

            LoginResponseDTO response = new LoginResponseDTO(usersFacade.findByEmail(data.login()), token);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + e.getMessage());
        }
    }

    /**
     * Endpoint responsável pelo registro de um novo usuário no sistema.
     * Recebe as informações de login e senha, cria um novo usuário e o persiste.
     *
     * @param data os dados de registro do usuário ({@link RegisterDTO} contendo login e senha).
     * @return uma resposta HTTP com o objeto {@link Users} salvo no sistema e status HTTP 200 (OK).
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO data) {
        try {
            Users userSave = usersFacade.save(data);

            return new ResponseEntity<Users>(userSave, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao registrar usuário: " + e.getMessage());
        }
    }
}

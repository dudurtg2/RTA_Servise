package com.example.empresa.controllers;

import com.example.empresa.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empresa.entities.Users;
import com.example.empresa.facades.UsersFacade;
import com.example.empresa.security.DTO.AccessTokenResponseDTO;
import com.example.empresa.security.DTO.AuthorizationDTO;
import com.example.empresa.security.DTO.LoginResponseDTO;
import com.example.empresa.security.DTO.RefreshTokenDTO;
import com.example.empresa.security.DTO.RegisterDTO;

/**
 * Controlador responsável pelas operações de autenticação e registro de
 * usuários no sistema.
 * Possui endpoints para login e registro de novos usuários.
 */
@RestController
@RequestMapping("/auth")
public class UsersController {

    private final AuthenticationManager authenticationManager;
    private UsersFacade usersFacade;
    private final TokenService tokenService;

    /**
     * Construtor para injeção das dependências necessárias para o controle de
     * autenticação.
     *
     * @param tokenService          o serviço responsável pela geração do token de
     *                              autenticação.
     * @param authenticationManager o gerenciador de autenticação para validar
     *                              credenciais.
     * @param usersFacade           a fachada que gerencia as operações de CRUD
     *                              sobre a entidade {@link Users}.
     */
    @Autowired
    public UsersController(TokenService tokenService, AuthenticationManager authenticationManager,
            UsersFacade usersFacade) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.usersFacade = usersFacade;
    }

    /**
     * Endpoint responsável por realizar o login de um usuário no sistema.
     * Recebe as credenciais (login e senha), valida-as e retorna um token de
     * autenticação.
     *
     * @param data os dados de login do usuário ({@link AuthorizationDTO} contendo
     *             login e senha).
     * @return uma resposta HTTP com o token gerado para autenticação.
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthorizationDTO data) {
        try {
            var usernamePass = new UsernamePasswordAuthenticationToken(
                    data.login().toLowerCase(), 
                    data.senha() 
            );
            var auth = this.authenticationManager.authenticate(usernamePass);
            var user = (Users) auth.getPrincipal();
            var tokens = tokenService.generateTokens(user);
            var response = new LoginResponseDTO(usersFacade.findByEmail(data.login()), tokens);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            return ResponseEntity.status(401).body("Credenciais inválidas ou autenticação falhou.");
        }
    }

    /**
     * Endpoint responsável por renovar o Access Token de um usuário no sistema.
     * Recebe um Refresh Token, valida-o e, caso seja válido, gera e retorna um novo Access Token.
     *
     * @param refreshTokenRequest o objeto contendo o Refresh Token do usuário ({@link RefreshTokenDTO}).
     * @return uma resposta HTTP com o novo Access Token gerado, ou status HTTP 401 (Unauthorized) se o Refresh Token for inválido ou expirado.
     */
    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenDTO refreshTokenRequest) {
        
        String login = tokenService.validateRefreshToken(refreshTokenRequest.refreshToken());
        if (login == null) {
            return ResponseEntity.status(401).body("Refresh Token inválido ou expirado.");
        }

        Users user = usersFacade.findByLogin(login);

        return ResponseEntity.ok(new AccessTokenResponseDTO(tokenService.generateAccessToken(user)));
    }


    /**
     * Endpoint responsável pelo registro de um novo usuário no sistema.
     * Recebe as informações de login e senha, cria um novo usuário e o persiste.
     *
     * @param data os dados de registro do usuário ({@link RegisterDTO} contendo
     *             login e senha).
     * @return uma resposta HTTP com o objeto {@link Users} salvo no sistema e
     *         status HTTP 200 (OK).
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO data) {

        Users userSave = usersFacade.save(data);

        return new ResponseEntity<Users>(userSave, HttpStatus.CREATED);

    }
}

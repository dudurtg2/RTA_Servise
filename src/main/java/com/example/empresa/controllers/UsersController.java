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

@RestController
@RequestMapping("/auth")
public class UsersController {

    private final AuthenticationManager authenticationManager;
    private UsersFacade usersFacade;
    private final TokenService tokenService;

    @Autowired
    public UsersController(TokenService tokenService, AuthenticationManager authenticationManager,
            UsersFacade usersFacade) {
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.usersFacade = usersFacade;
    }

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

    @PostMapping("/refresh-token")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenDTO refreshTokenRequest) {
        
        String login = tokenService.validateRefreshToken(refreshTokenRequest.refreshToken());
        if (login == null) {
            return ResponseEntity.status(401).body("Refresh Token inválido ou expirado.");
        }

        Users user = usersFacade.findByLogin(login);

        return ResponseEntity.ok(new AccessTokenResponseDTO(tokenService.generateAccessToken(user)));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO data) {

        Users userSave = usersFacade.save(data);

        return new ResponseEntity<Users>(userSave, HttpStatus.CREATED);

    }
}


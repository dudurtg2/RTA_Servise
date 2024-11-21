package com.example.empresa.controllers;

import com.example.empresa.services.TokenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.empresa.entities.Users;
import com.example.empresa.facades.UsersFacade;
import com.example.empresa.security.DTO.AuthorizationDTO;
import com.example.empresa.security.DTO.LoginResponseDTO;
import com.example.empresa.security.DTO.RegisterDTO;

@RestController
@RequestMapping("/auth")
public class UsersController {
    private AuthenticationManager authenticationManager;
    private UsersFacade usersFacade;
    private TokenService tokenService;

    @Autowired
    public UsersController(TokenService tokenService ,AuthenticationManager authenticationManager, UsersFacade usersFacade){
        this.tokenService = tokenService;
        this.authenticationManager = authenticationManager;
        this.usersFacade = usersFacade;

    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthorizationDTO data) {
        var usernamePass = new UsernamePasswordAuthenticationToken(data.login(), data.senha());
        var auth = this.authenticationManager.authenticate(usernamePass);

        var token = tokenService.generateToken((Users) auth.getPrincipal());
        

        return ResponseEntity.ok(new LoginResponseDTO(token));

    }

    @PostMapping("/register")
    public ResponseEntity<Users> register(@RequestBody RegisterDTO data) {
        
        String senha = new BCryptPasswordEncoder().encode(data.senha());
        Users userSave = usersFacade.save(new Users(data.login(), senha, data.role()));

        return new ResponseEntity<Users>(userSave, HttpStatus.OK);

    }
}
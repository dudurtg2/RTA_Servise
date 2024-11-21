package com.example.empresa.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.empresa.entities.Users;

/**
 * Serviço responsável pela geração e validação de tokens JWT (JSON Web Token) 
 * utilizados para autenticação e autorização de usuários no sistema.
 * 
 * A classe utiliza a biblioteca `auth0.jwt` para manipulação de tokens JWT, criando tokens seguros 
 * e verificando sua validade durante as requisições.
 */
@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    /**
     * Gera um token JWT para o usuário fornecido.
     * 
     * @param users o usuário para o qual o token será gerado.
     * @return o token JWT gerado.
     * @throws RuntimeException caso ocorra um erro durante a criação do token.
     */
    public String generateToken(Users users) {
        try {
            // Cria o algoritmo de assinatura HMAC256 com a chave secreta
            Algorithm algorithms = Algorithm.HMAC256(secret);

            // Criação do token JWT
            String token = JWT.create()
                .withIssuer("auth-api") // Emitente do token
                .withSubject(users.getLogin()) // Login do usuário como assunto
                .withExpiresAt(genExpirInstant()) // Definição da data de expiração
                .sign(algorithms); // Assinatura do token

            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token", e);
        }
    }

    /**
     * Gera a data de expiração do token como um instante de 2 dias a partir da data atual.
     * 
     * @return um instante de expiração do token.
     */
    private Instant genExpirInstant() {
        return LocalDateTime.now().plusDays(2).toInstant(ZoneOffset.of("-03:00"));
    }

    /**
     * Valida um token JWT fornecido e retorna o login do usuário associado ao token, caso seja válido.
     * Caso o token seja inválido ou expirado, retorna `null`.
     * 
     * @param token o token JWT a ser validado.
     * @return o login do usuário associado ao token, ou `null` se o token for inválido ou expirado.
     */
    public String validateToken(String token) {
        try {
            // Cria o algoritmo de assinatura HMAC256 com a chave secreta
            Algorithm algorithms = Algorithm.HMAC256(secret);

            // Valida o token e extrai o login (subject) do usuário
            return JWT.require(algorithms)
                .withIssuer("auth-api") // Verifica se o emissor é o esperado
                .build()
                .verify(token) // Verifica a validade do token
                .getSubject(); // Retorna o login (subject) do usuário
        } catch (JWTVerificationException e) {
            return null; // Caso o token seja inválido ou expirado
        }
    }
}

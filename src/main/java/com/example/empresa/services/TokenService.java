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
import com.example.empresa.security.DTO.TokensDTO;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    /**
     * Gera o Access Token (duração curta) para autenticação do usuário.
     *
     * @param users o usuário para o qual o token será gerado.
     * @return o Access Token JWT gerado.
     */
    public String generateAccessToken(Users users) {
        return generateToken(users, genAccessTokenExpiry());
    }

    /**
     * Gera o Refresh Token (duração longa) para renovação do Access Token.
     *
     * @param users o usuário para o qual o token será gerado.
     * @return o Refresh Token JWT gerado.
     */
    public String generateRefreshToken(Users users) {
        return generateToken(users, genRefreshTokenExpiry());
    }

    /**
     * Gera ambos os tokens (Access Token e Refresh Token) para o usuário.
     *
     * @param users o usuário para o qual os tokens serão gerados.
     * @return um objeto `Tokens` contendo o Access Token e o Refresh Token.
     */
    public TokensDTO generateTokens(Users users) {
        String accessToken = generateAccessToken(users);
        String refreshToken = generateRefreshToken(users);
        return new TokensDTO(accessToken, refreshToken);
    }

    /**
     * Valida um Access Token JWT fornecido e retorna o login do usuário associado, caso seja válido.
     * Caso o token seja inválido ou expirado, retorna `null`.
     *
     * @param accessToken o Access Token JWT a ser validado.
     * @return o login do usuário associado ao token, ou `null` se o token for inválido ou expirado.
     */
    public String validateAccessToken(String accessToken) {
        return validateToken(accessToken, "access");
    }

    /**
     * Valida um Refresh Token JWT fornecido e retorna o login do usuário associado, caso seja válido.
     * Caso o token seja inválido ou expirado, retorna `null`.
     *
     * @param refreshToken o Refresh Token JWT a ser validado.
     * @return o login do usuário associado ao token, ou `null` se o token for inválido ou expirado.
     */
    public String validateRefreshToken(String refreshToken) {
        return validateToken(refreshToken, "refresh");
    }

    /**
     * Método interno para validar um token JWT genérico.
     *
     * @param token o token JWT a ser validado.
     * @param type o tipo de token ("access" ou "refresh").
     * @return o login do usuário associado ao token, ou `null` se o token for inválido ou expirado.
     */
    public String validateToken(String token, String type) {
        try {
            Algorithm algorithms = Algorithm.HMAC256(secret);

            // Valida o token
            return JWT.require(algorithms)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }

    /**
     * Método interno para criar um token JWT genérico.
     *
     * @param users o usuário para o qual o token será gerado.
     * @param expiry o tempo de expiração do token.
     * @return o token JWT gerado.
     */
    private String generateToken(Users users, Instant expiry) {
        try {
            Algorithm algorithms = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer("auth-api")
                    .withSubject(users.getLogin())
                    .withExpiresAt(expiry)
                    .sign(algorithms);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token", e);
        }
    }

    /**
     * Gera a data de expiração para o Access Token (15 minutos).
     */
    private Instant genAccessTokenExpiry() {
        return LocalDateTime.now().plusMinutes(15).toInstant(ZoneOffset.of("-03:00"));
    }

    /**
     * Gera a data de expiração para o Refresh Token (7 dias).
     */
    private Instant genRefreshTokenExpiry() {
        return LocalDateTime.now().plusDays(7).toInstant(ZoneOffset.of("-03:00"));
    }

    

}

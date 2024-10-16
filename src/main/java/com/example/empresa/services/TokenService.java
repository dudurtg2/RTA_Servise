package com.example.empresa.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.example.empresa.entities.Users;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    public String generateToken(Users users) {
        try {
            Algorithm algorithms = Algorithm.HMAC256(secret);
            String token = JWT.create()
                .withIssuer("auth-api")
                    .withSubject(users.getLogin())
                    .withExpiresAt(genExpirInstant())
                    .sign(algorithms);

            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token", e);
        }
    }
    private Instant genExpirInstant() {
        return LocalDateTime.now().plusDays(2).toInstant(ZoneOffset.of("-03:00"));
    }


    public String validateToken(String token) {
        try {
            Algorithm algorithms = Algorithm.HMAC256(secret);
            return JWT.require(algorithms)
                .withIssuer("auth-api")
                .build()
                .verify(token)
                .getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}

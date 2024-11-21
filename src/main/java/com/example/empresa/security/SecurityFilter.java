package com.example.empresa.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.empresa.services.GetUserService;
import com.example.empresa.services.TokenService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Filtro de segurança que valida o token JWT presente na requisição e, caso válido,
 * autentica o usuário no contexto de segurança do Spring.
 * 
 * Este filtro é executado uma vez por requisição HTTP, interceptando a requisição
 * para verificar a validade do token e preencher o contexto de segurança com as
 * informações do usuário, caso o token seja válido.
 */
@Component
public class SecurityFilter extends OncePerRequestFilter {

    private GetUserService getUserService;
    private TokenService tokenService;

    /**
     * Construtor para injeção de dependências do {@link GetUserService} e 
     * {@link TokenService}.
     * 
     * @param getUserService serviço para buscar o usuário a partir do login.
     * @param tokenService serviço para validação e extração de informações do token.
     */
    @Autowired
    public SecurityFilter(GetUserService getUserService, TokenService tokenService) {
        this.getUserService = getUserService;
        this.tokenService = tokenService;
    }

    /**
     * Método responsável por filtrar a requisição HTTP, recuperando e validando o token JWT.
     * Caso o token seja válido, autentica o usuário no contexto de segurança do Spring.
     * 
     * @param request a requisição HTTP.
     * @param response a resposta HTTP.
     * @param filterChain a cadeia de filtros a ser executada após o filtro atual.
     * @throws ServletException caso ocorra algum erro ao processar o filtro.
     * @throws IOException caso ocorra algum erro de entrada/saída ao processar o filtro.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

        if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var subject = tokenService.validateToken(token);
            UserDetails userDetails = getUserService.findByLogin(subject);

            if (userDetails != null) {
                var auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        filterChain.doFilter(request, response);
    }

    /**
     * Recupera o token JWT da requisição HTTP, verificando o cabeçalho "Authorization".
     * O token deve estar no formato "Bearer {token}".
     * 
     * @param request a requisição HTTP.
     * @return o token JWT ou {@code null} caso não seja encontrado um token válido.
     */
    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }

        return authHeader.replace("Bearer ", "");
    }
}

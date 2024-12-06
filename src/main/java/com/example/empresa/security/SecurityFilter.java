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
     * Executa o filtro de seguran a, verificando se o token JWT est  presente na
     * requisi o e, caso esteja, autenticando o usu rio no contexto de
     * seguran a do Spring.
     * 
     * Este m todo intercepta a requisi o e verifica a validade do token, caso
     * esteja v lido, preenche o contexto de seguran a com as informa es do
     * usu rio.
     * 
     * @param request   a requisi o HTTP que est  sendo processada.
     * @param response  a resposta HTTP que ser  enviada.
     * @param filterChain o filtro de requisi o que est  sendo executado.
     * @throws ServletException caso haja um erro ao executar o filtro.
     * @throws IOException     caso haja um erro ao processar a requisi o.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

        if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var subject = tokenService.validateToken(token, "access");
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

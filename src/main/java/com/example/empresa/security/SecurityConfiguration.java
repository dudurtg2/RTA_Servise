package com.example.empresa.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuração de segurança da aplicação.
 * Define as regras de autenticação e autorização de requisições HTTP, 
 * bem como a configuração do filtro de segurança personalizado.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private SecurityFilter securityFilter;

    @Autowired
    public  SecurityConfiguration(SecurityFilter securityFilter){
        this.securityFilter = securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .cors() 
            .and()
            .csrf().disable()  
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                
                .requestMatchers(HttpMethod.POST, "/auth/**").permitAll() 
        
                .requestMatchers( "/api/bases/**").hasAnyRole("ENTREGADOR", "ADMIN", "GERENTE")
                .requestMatchers( "/api/cidades/**").hasAnyRole( "ADMIN", "GERENTE", "FUNCIONARIO", "ENTREGADOR")
                .requestMatchers( "/api/codigos/**").hasAnyRole( "ADMIN", "GERENTE", "FUNCIONARIO", "ENTREGADOR")
                .requestMatchers( "/api/empresas/**").hasAnyRole("ADMIN", "GERENTE")
                .requestMatchers( "/api/entregadores/**").hasAnyRole( "ADMIN", "GERENTE", "FUNCIONARIO", "ENTREGADOR")
                .requestMatchers( "/api/funcionarios/**").hasAnyRole( "ADMIN", "GERENTE", "FUNCIONARIO")
                .requestMatchers( "/api/motoristas/**").hasAnyRole("MOTORISTA", "ADMIN", "GERENTE", "FUNCIONARIO")
                .requestMatchers( "/api/regioes/**").hasAnyRole( "ADMIN", "GERENTE")
                .requestMatchers( "/api/romaneios/**").hasAnyRole("MOTORISTA", "ADMIN", "GERENTE", "FUNCIONARIO", "ENTREGADOR")

            )
            .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) 
            .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

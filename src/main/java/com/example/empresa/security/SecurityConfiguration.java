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
        
                .requestMatchers("/api/**").hasRole("ADMIN")

                .requestMatchers(HttpMethod.GET, "/api/romaneios/findAll").hasRole("MOTORISTA")
                .requestMatchers(HttpMethod.GET, "/api/romaneios/count/**").hasRole("MOTORISTA")
                .requestMatchers(HttpMethod.GET, "/api/romaneios/findBySearch/**").hasRole("MOTORISTA")
                .requestMatchers(HttpMethod.PUT, "/api/romaneios/update/**").hasRole("MOTORISTA")
                .requestMatchers(HttpMethod.PUT, "/api/motoristas/update/**").hasRole("MOTORISTA")


                .requestMatchers(HttpMethod.GET,"/api/romaneios/findAll").hasRole("ENTREGADOR")
                .requestMatchers(HttpMethod.GET,"/api/romaneios/count/**").hasRole("ENTREGADOR")
                .requestMatchers(HttpMethod.PUT,"/api/romaneios/update/**").hasRole("ENTREGADOR")

                .requestMatchers(HttpMethod.POST,"/api/entregador/save").hasRole("USER")
                .requestMatchers(HttpMethod.PUT,"/api/entregador/update/**").hasRole("USER")
                .requestMatchers(HttpMethod.DELETE,"/api/entregador/deleteById/**").hasRole("USER")

                .requestMatchers(HttpMethod.POST,"/api/motorista/save").hasRole("USER")
                .requestMatchers(HttpMethod.PUT,"/api/motorista/update/**").hasRole("USER")
                .requestMatchers(HttpMethod.DELETE,"/api/motorista/deleteById/**").hasRole("USER")

                .requestMatchers(HttpMethod.POST,"/api/funcionario/save").hasRole("USER")
                .requestMatchers(HttpMethod.PUT,"/api/funcionario/update/**").hasRole("USER")
                .requestMatchers(HttpMethod.DELETE,"/api/funcionario/deleteById/**").hasRole("USER")

                .requestMatchers(HttpMethod.POST,"/api/entregador/save").hasRole("SAC")
                .requestMatchers(HttpMethod.PUT,"/api/entregador/update/**").hasRole("SAC")
                .requestMatchers(HttpMethod.DELETE,"/api/entregador/deleteById/**").hasRole("SAC")

                .requestMatchers(HttpMethod.POST,"/api/motorista/save").hasRole("SAC")
                .requestMatchers(HttpMethod.PUT,"/api/motorista/update/**").hasRole("SAC")
                .requestMatchers(HttpMethod.DELETE,"/api/motorista/deleteById/**").hasRole("SAC")

                .requestMatchers(HttpMethod.POST,"/api/funcionario/save").hasRole("SAC")
                .requestMatchers(HttpMethod.PUT,"/api/funcionario/update/**").hasRole("SAC")
                .requestMatchers(HttpMethod.DELETE,"/api/funcionario/deleteById/**").hasRole("SAC")


                
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

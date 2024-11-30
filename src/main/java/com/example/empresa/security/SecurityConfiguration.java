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

    /**
     * Construtor para injeção de dependência do {@link SecurityFilter}.
     * 
     * @param securityFilter filtro de segurança personalizado.
     */

    @Autowired
    public  SecurityConfiguration(SecurityFilter securityFilter){
        this.securityFilter = securityFilter;
    }

    /**
     * Configura o filtro de segurança, desabilita o CSRF, define a política de sessão como sem estado
     * e configura as permissões de acesso para os endpoints.
     * 
     * @param http o objeto {@link HttpSecurity} para configurar as regras de segurança.
     * @return uma instância de {@link SecurityFilterChain} configurada.
     * @throws Exception se houver falha ao configurar o filtro de segurança.
     */

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .cors() 
            .and()
            .csrf().disable()  
            .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                
                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll() 
                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                
                .requestMatchers(HttpMethod.POST, "/api/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/api/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.GET, "/api/**").hasRole("ADMIN")

                .requestMatchers(HttpMethod.GET, "/api/romaneios/findAll").hasRole("MOTORISTA")
                .requestMatchers(HttpMethod.GET, "/api/romaneios/count/**").hasRole("MOTORISTA")
                .requestMatchers(HttpMethod.PUT, "/api/romaneios/update/**").hasRole("MOTORISTA")

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

    /**
     * Configura o {@link AuthenticationManager} para a aplicação.
     * 
     * @param authenticationConfiguration a configuração de autenticação do Spring Security.
     * @return o {@link AuthenticationManager} configurado.
     * @throws Exception se houver falha ao configurar o manager de autenticação.
     */

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    /**
     * Configura o codificador de senhas a ser utilizado, no caso o {@link BCryptPasswordEncoder}.
     * 
     * @return uma instância de {@link PasswordEncoder} configurada.
     */

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

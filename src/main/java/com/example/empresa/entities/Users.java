package com.example.empresa.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.empresa.entities.emuns.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Users")
@Entity
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "login", nullable = false, unique = true)
    private String login;
    
    @Column(name= "senha", nullable = false)
    private String senha;

    @Column(name = "role", nullable = false)
    private UserRole role;

    public Users(String login, String senha, UserRole role) {
        this.login = login;
        this.senha = senha;
        this.role = role;
    }
    
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == UserRole.ADMIN) return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else if(this.role == UserRole.MOTORISTA) return List.of(new SimpleGrantedAuthority("ROLE_MOTORISTA"), new SimpleGrantedAuthority("ROLE_USER"));
        else if(this.role == UserRole.FUNCIONARIO) return List.of(new SimpleGrantedAuthority("ROLE_FUNCIONARIO"), new SimpleGrantedAuthority("ROLE_USER"));
        else if(this.role == UserRole.ENTREGADOR) return List.of(new SimpleGrantedAuthority("ROLE_ENTREGADOR"), new SimpleGrantedAuthority("ROLE_USER"));
        else if(this.role == UserRole.SAC) return List.of(new SimpleGrantedAuthority("ROLE_SAC"), new SimpleGrantedAuthority("ROLE_USER"));
        else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

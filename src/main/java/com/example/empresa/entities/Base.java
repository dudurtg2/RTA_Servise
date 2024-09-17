package com.example.empresa.entities;

import jakarta.persistence.*;

@Table(name = "base")
@Entity
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name= "endereco", nullable = false)
    private String endereco;

    public Base() {}

    public Base(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}

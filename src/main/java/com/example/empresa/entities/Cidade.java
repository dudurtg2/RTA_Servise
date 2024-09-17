package com.example.empresa.entities;

import jakarta.persistence.*;

@Table(name = "cidade")
@Entity
public class Cidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "regiao_id", nullable = false)
    private int regiao_id;

    public Cidade() {}

    public Cidade(String nome, int regiao_id) {
        this.nome = nome;
        this.regiao_id = regiao_id;
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

    public int getRegiao_id() {
        return this.regiao_id;
    }

    public void setRegiao_id(int regiao_id) {
        this.regiao_id = regiao_id;
    }

}

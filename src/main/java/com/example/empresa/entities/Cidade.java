package com.example.empresa.entities;

import jakarta.persistence.*;

@Table(name = "Cidade")
@Entity
public class Cidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "cep", nullable = false)
    private String cep;

    @ManyToOne
    @JoinColumn(name = "idRegiao")
    private Regiao idRegiao;

    public Cidade() {}

    public Cidade(String nome, String cep, Regiao IdRegiao) {
        this.nome = nome;
        this.idRegiao = IdRegiao;
        this.cep = cep;
    }
    
    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public Regiao getIdRegiao() {
        return this.idRegiao;
    }

    public void setIdRegiao(Regiao idRegiao) {
        this.idRegiao = idRegiao;
    }

}

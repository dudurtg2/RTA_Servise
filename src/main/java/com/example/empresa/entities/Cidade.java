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
    
    @Column(name = "cep", nullable = false)
    private String cep;

    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @ManyToOne
    @JoinColumn(name = "regiao_id")
    private Regiao regiao_id;

    public Cidade() {}

    public Cidade(String nome, String cep, Regiao regiao_id) {
        this.nome = nome;
        this.regiao_id = regiao_id;
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

    public Regiao getRegiao_id() {
        return this.regiao_id;
    }

    public void setRegiao_id(Regiao regiao_id) {
        this.regiao_id = regiao_id;
    }

}

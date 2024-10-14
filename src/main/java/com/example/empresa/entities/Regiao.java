package com.example.empresa.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Regiao")
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @JoinColumn(name = "idBase")
    @ManyToOne
    private Base idBase;

    public Regiao() {}

    public Regiao(String nome, Base idBase) {
        this.nome = nome;
        this.idBase = idBase;
    }

    public Base getIdBase() {
        return this.idBase;
    }

    public void setIdBase(Base idBase) {
        this.idBase = idBase;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}

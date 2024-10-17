package com.example.empresa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Regiao")
public class Regiao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "nome")
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

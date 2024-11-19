package com.example.empresa.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "Codigo")
@Entity
public class Codigo {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo")
    private String codigo;
    
    @ManyToOne
    @JoinColumn(name = "romaneio", referencedColumnName = "id", nullable = false) 
    private Romaneio romaneio;
    
    public Codigo() {}

    public Codigo(int id, Romaneio romaneio, String codigo) {
        this.id = id;
        this.romaneio = romaneio;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setRomaneio(Romaneio romaneio) {
        this.romaneio = romaneio;
    }
}

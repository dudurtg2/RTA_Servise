package com.example.empresa.entities;

import jakarta.persistence.*;

@Table(name = "codigo")
@Entity
public class Codigo {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;
    
    @Column(name = "id_romaneio", nullable = false)
    private int id_romaneio;
    
    public Codigo() {}

    public Codigo(String id, int id_romaneio) {
        this.id = id;
        this.id_romaneio = id_romaneio;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getId_romaneio() {
        return this.id_romaneio;
    }

    public void setId_romaneio(int id_romaneio) {
        this.id_romaneio = id_romaneio;
    }

}

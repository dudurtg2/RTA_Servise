package com.example.empresa.entities;

import jakarta.persistence.*;

@Table(name = "codigo")
@Entity
public class Codigo {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "codigo", nullable = false)
    private String codigo;
    
    @ManyToOne
    @JoinColumn(name = "id_romaneio")
    private Romaneio id_romaneio;
    
    public Codigo() {}

    public Codigo(String id, Romaneio id_romaneio, String codigo) {
        this.id = id;
        this.id_romaneio = id_romaneio;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Romaneio getId_romaneio() {
        return this.id_romaneio;
    }

    public void setId_romaneio(Romaneio id_romaneio) {
        this.id_romaneio = id_romaneio;
    }

}

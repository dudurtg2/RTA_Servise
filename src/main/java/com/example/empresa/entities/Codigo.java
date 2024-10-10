package com.example.empresa.entities;

import jakarta.persistence.*;

@Table(name = "Codigo")
@Entity
public class Codigo {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(name = "codigo", nullable = false)
    private String codigo;
    
    @ManyToOne
    @JoinColumn(name = "idRomaneio")
    private Romaneio idRomaneio;
    
    public Codigo() {}

    public Codigo(String id, Romaneio idRomaneio, String codigo) {
        this.id = id;
        this.idRomaneio = idRomaneio;
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

    public Romaneio getIdRomaneio() {
        return this.idRomaneio;
    }

    public void setIdRomaneio(Romaneio idRomaneio) {
        this.idRomaneio = idRomaneio;
    }

}

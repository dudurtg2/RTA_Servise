package com.example.empresa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "Historico")
@Entity
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "dataCriacao")
    private String dataCriacao;

    @Column(name = "dataSaida")
    private String dataSaida;

    @Column(name = "dataFinalizacao")
    private String dataFinalizacao;
    
    @Column(name = "idRomaneio")
    private int idRomaneio;
    
    public Historico() {}

    public Historico(String dataCriacao, String dataSaida, String dataFinalizacao, int idRomaneio) {
        this.dataCriacao = dataCriacao;
        this.dataSaida = dataSaida;
        this.dataFinalizacao = dataFinalizacao;
        this.idRomaneio = idRomaneio;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(String dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDataSaida() {
        return this.dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDataFinalizacao() {
        return this.dataFinalizacao;
    }

    public void setDataFinalizacao(String dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

    public int getidRomaneio() {
        return this.idRomaneio;
    }

    public void setidRomaneio(int idRomaneio) {
        this.idRomaneio = idRomaneio;
    }

}   

package com.example.empresa.entities;

import jakarta.persistence.*;

@Table(name = "historico")
@Entity
public class Historico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data_criacao", nullable = false)
    private String data_criacao;

    @Column(name = "data_saida", nullable = false)
    private String data_saida;

    @Column(name = "data_finalizacao", nullable = false)
    private String data_finalizacao;
    
    @Column(name = "romaneio_id", nullable = false)
    private int romaneio_id;
    
    public Historico() {}

    public Historico(String data_criacao, String data_saida, String data_finalizacao, int romaneio_id) {
        this.data_criacao = data_criacao;
        this.data_saida = data_saida;
        this.data_finalizacao = data_finalizacao;
        this.romaneio_id = romaneio_id;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_criacao() {
        return this.data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao = data_criacao;
    }

    public String getData_saida() {
        return this.data_saida;
    }

    public void setData_saida(String data_saida) {
        this.data_saida = data_saida;
    }

    public String getData_finalizacao() {
        return this.data_finalizacao;
    }

    public void setData_finalizacao(String data_finalizacao) {
        this.data_finalizacao = data_finalizacao;
    }

    public int getRomaneio_id() {
        return this.romaneio_id;
    }

    public void setRomaneio_id(int romaneio_id) {
        this.romaneio_id = romaneio_id;
    }

}   

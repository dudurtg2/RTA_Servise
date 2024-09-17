package com.example.empresa.entities;

import jakarta.persistence.*;

@Table(name = "romaneio")
@Entity
public class Romaneio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "empresa_id", nullable = false)
    private int empresa_id;

    @Column(name = "motorista_id", nullable = false)
    private int motorista_id;

    @Column(name = "entregador_id", nullable = false)
    private int entregador_id;

    @Column(name = "funcionario_id", nullable = false)
    private int funcionario_id;

    @Column(name = "base_id", nullable = false)
    private int base_id;

    @Column(name = "cidade_id", nullable = false)
    private int cidade_id;

    @Column(name = "sts", nullable = false)
    private String sts;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "sacas", nullable = false)
    private int sacas;

    @Column (name = "caixas", nullable = false) 
    private int caixas;

    public Romaneio() {}

    public Romaneio(int empresa_id, int motorista_id, int entregador_id, int funcionario_id, int base_id, int cidade_id, String sts, int quantidade, int sacas, int caixas) {
        this.empresa_id = empresa_id;
        this.motorista_id = motorista_id;
        this.entregador_id = entregador_id;
        this.funcionario_id = funcionario_id;
        this.base_id = base_id;
        this.cidade_id = cidade_id;
        this.sts = sts;
        this.quantidade = quantidade;
        this.sacas = sacas;
        this.caixas = caixas;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpresa_id() {
        return this.empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public int getMotorista_id() {
        return this.motorista_id;
    }

    public void setMotorista_id(int motorista_id) {
        this.motorista_id = motorista_id;
    }

    public int getEntregador_id() {
        return this.entregador_id;
    }

    public void setEntregador_id(int entregador_id) {
        this.entregador_id = entregador_id;
    }

    public int getFuncionario_id() {
        return this.funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public int getBase_id() {
        return this.base_id;
    }

    public void setBase_id(int base_id) {
        this.base_id = base_id;
    }

    public int getCidade_id() {
        return this.cidade_id;
    }

    public void setCidade_id(int cidade_id) {
        this.cidade_id = cidade_id;
    }

    public String getSts() {
        return this.sts;
    }

    public void setSts(String sts) {
        this.sts = sts;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getSacas() {
        return this.sacas;
    }

    public void setSacas(int sacas) {
        this.sacas = sacas;
    }

    public int getCaixas() {
        return this.caixas;
    }

    public void setCaixas(int caixas) {
        this.caixas = caixas;
    }


}

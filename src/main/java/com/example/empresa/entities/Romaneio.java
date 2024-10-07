package com.example.empresa.entities;

import jakarta.persistence.*;

@Table(name = "romaneio")
@Entity
public class Romaneio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa_id;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista_id;

    @ManyToOne
    @JoinColumn(name = "entregador_id")
    private Entregador entregador_id;
    
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario_id;

    @ManyToOne
    @JoinColumn(name = "base_id")
    private Base base_id;

    @ManyToOne
    @JoinColumn(name = "cidade_id")
    private Cidade cidade_id;

    @Column(name = "sts")
    private String sts;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "sacas")
    private int sacas;

    @Column (name = "caixas") 
    private int caixas;

    public Romaneio() {}

    public Romaneio(int id, Empresa empresa_id, Motorista motorista_id, Entregador entregador_id, Funcionario funcionario_id, Base base_id, Cidade cidade_id, String sts, int quantidade, int sacas, int caixas) {
        this.id = id;
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

    public Empresa getEmpresa_id() {
        return this.empresa_id;
    }

    public void setEmpresa_id(Empresa empresa_id) {
        this.empresa_id = empresa_id;
    }

    public Motorista getMotorista_id() {
        return this.motorista_id;
    }

    public void setMotorista_id(Motorista motorista_id) {
        this.motorista_id = motorista_id;
    }

    public Entregador getEntregador_id() {
        return this.entregador_id;
    }

    public void setEntregador_id(Entregador entregador_id) {
        this.entregador_id = entregador_id;
    }

    public Funcionario getFuncionario_id() {
        return this.funcionario_id;
    }

    public void setFuncionario_id(Funcionario funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public Base getBase_id() {
        return this.base_id;
    }

    public void setBase_id(Base base_id) {
        this.base_id = base_id;
    }

    public Cidade getCidade_id() {
        return this.cidade_id;
    }

    public void setCidade_id(Cidade cidade_id) {
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

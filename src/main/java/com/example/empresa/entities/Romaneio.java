package com.example.empresa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "Romaneio")
@Entity
public class Romaneio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @ManyToOne
    @JoinColumn(name = "idEmpresa")
    private Empresa idEmpresa;

    @ManyToOne
    @JoinColumn(name = "idMotorista")
    private Motorista idMotorista;

    @ManyToOne
    @JoinColumn(name = "idEntregador")
    private Entregador idEntregador;
    
    @ManyToOne
    @JoinColumn(name = "idFuncionario")
    private Funcionario idFuncionario;

    @ManyToOne
    @JoinColumn(name = "idBase")
    private Base idBase;

    @ManyToOne
    @JoinColumn(name = "idCidade")
    private Cidade idCidade;

    @Column(name = "sts")
    private String sts;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "sacas")
    private int sacas;

    @Column (name = "caixas") 
    private int caixas;

    @Column(name = "CodigoUid")
    private String CodigoUid;

    public Romaneio() {}

    public Romaneio(int id, Empresa idEmpresa, Motorista idMotorista, Entregador idEntregador, Funcionario idFuncionario, Base idBase, Cidade idCidade, String sts, int quantidade, int sacas, int caixas, String CodigoUid) {
        this.id = id;
        this.idEmpresa = idEmpresa;
        this.idMotorista = idMotorista;
        this.idEntregador = idEntregador;
        this.idFuncionario = idFuncionario;
        this.idBase = idBase;
        this.idCidade = idCidade;
        this.sts = sts;
        this.quantidade = quantidade;
        this.sacas = sacas;
        this.caixas = caixas;
        this.CodigoUid = CodigoUid;
    }
    

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empresa getIdEmpresa() {
        return this.idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Motorista getIdMotorista() {
        return this.idMotorista;
    }

    public void setIdMotorista(Motorista idMotorista) {
        this.idMotorista = idMotorista;
    }

    public Entregador getIdEntregador() {
        return this.idEntregador;
    }

    public void setIdEntregador(Entregador idEntregador) {
        this.idEntregador = idEntregador;
    }

    public Funcionario getIdFuncionario() {
        return this.idFuncionario;
    }

    public void setIdFuncionario(Funcionario idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Base getIdBase() {
        return this.idBase;
    }

    public void setIdBase(Base idBase) {
        this.idBase = idBase;
    }

    public Cidade getIdCidade() {
        return this.idCidade;
    }

    public void setIdCidade(Cidade idCidade) {
        this.idCidade = idCidade;
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

    public String getCodigoUid() {
        return this.CodigoUid;
    }

    public void setCodigoUid(String CodigoUid) {
        this.CodigoUid = CodigoUid;
    }

   
}

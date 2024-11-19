package com.example.empresa.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Table(name = "Romaneio")
@Entity
public class Romaneio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @ManyToOne
    @JoinColumn(name = "empresa") 
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "motorista") 
    private Motorista motorista;

    @ManyToOne
    @JoinColumn(name = "entregador") 
    private Entregador entregador;
    
    @ManyToOne
    @JoinColumn(name = "funcionario") 
    private Funcionario funcionario;

    @ManyToOne
    @JoinColumn(name = "base") 
    private Base base;

    @ManyToOne
    @JoinColumn(name = "cidade") 
    private Cidade cidade;

    @Column(name = "sts") 
    private String sts;

    @Column(name = "quantidade") 
    private int quantidade;

    @Column(name = "CodigoUid") 
    private String CodigoUid;

    @Column(name = "linkDownload") 
    private String linkDownload;

    @Column(name = "data") 
    private String data;

    @Column(name = "dataFinal")
    private String dataFinal;

    @Column(name = "ocorrencia")
    private String ocorrencia;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "romaneio")
    private List<Codigo> codigo = new ArrayList<>();

    public Romaneio() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Motorista getMotorista() {
        return this.motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public Entregador getEntregador() {
        return this.entregador;
    }

    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Base getBase() {
        return this.base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public Cidade getCidade() {
        return this.cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
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

    public String getCodigoUid() {
        return this.CodigoUid;
    }

    public void setCodigoUid(String CodigoUid) {
        this.CodigoUid = CodigoUid;
    }

    public String getLinkDownload() {
        return this.linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataFinal() {
        return this.dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getOcorrencia() {
        return this.ocorrencia;
    }

    public void setOcorrencia(String ocorrencia) {
        this.ocorrencia = ocorrencia;
    }

    public List<Codigo> getCodigo() {
        return this.codigo;
    }

    public void setCodigo(List<Codigo> codigo) {
        this.codigo = codigo;
    }

   
}

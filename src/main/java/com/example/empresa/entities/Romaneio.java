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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Romaneio")
@Entity
public class Romaneio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

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
   
}

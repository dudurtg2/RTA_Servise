package com.example.empresa.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "romaneio")
public class Romaneio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa")
    private Empresa empresa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "motorista")
    private Motorista motorista;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "entregador")
    private Entregador entregador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario")
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base")
    private Base base;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cidade")
    private Cidade cidade;

    @Column(name = "sts")
    private String sts;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "codigo_uid")
    private String codigoUid;

    @Column(name = "link_download")
    private String linkDownload;

    @Column(name = "data")
    private LocalDate data;

    @Column(name = "data_final")
    private LocalDate dataFinal;

    @Column(name = "ocorrencia")
    private String ocorrencia;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "romaneio", orphanRemoval = true)
    private List<Codigo> codigo = new ArrayList<>();

}

package com.example.empresa.entities;

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

    @ManyToMany
    @JoinTable(
            name = "romaneio_cidade", 
            joinColumns = @JoinColumn(name = "romaneio_id"), 
            inverseJoinColumns = @JoinColumn(name = "cidade_id") 
    )
    private List<Cidade> cidade = new ArrayList<>();

    @Column(name = "sts")
    private String sts;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "codigo_uid")
    private String codigoUid;

    @Column(name = "link_download")
    private String linkDownload;

    @Column(name = "data")
    private String data;

    @Column(name = "data_final")
    private String dataFinal;

    @Column(name = "ocorrencia")
    private String ocorrencia;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "romaneio", orphanRemoval = true)
    private List<Codigo> codigos = new ArrayList<>();

}

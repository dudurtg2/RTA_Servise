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

/* 
{
    "id": 1,
    "empresa": { "id": 1 },
    "motorista": { "id": 1},
    "entregador": { "id": 1},
    "funcionario": { "id": 1},
    "base": { "id": 1 },
    "cidade": { "id": 1 },
    "sts": "sts",
    "quantidade": 1,
    "codigouid": "codigo_uid",
    "linkDownload": "link_download",
    "data": "data",
    "datafinal": "data_final",
    "ocorrencia": "ocorrencia",
    "codigos": [
        { "codigo": "codigo1" },
        { "codigo": "codigo2" },
        { "codigo": "codigo3" },
        { "codigo": "codigo4" }
    ]
}
*/
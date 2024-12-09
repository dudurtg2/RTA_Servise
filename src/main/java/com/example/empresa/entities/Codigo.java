package com.example.empresa.entities;


import com.example.empresa.entities.records.CodidoRecord;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Codigo")
@Entity
public class Codigo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "codigo")
    private String codigo;
    
    @ManyToOne
    @JoinColumn(name = "romaneio", referencedColumnName = "id", nullable = false) 
    private Romaneio romaneio;
    
    public CodidoRecord getRomaneio() {
        return new CodidoRecord(romaneio.getCodigoUid(), romaneio.getId());
    }
    public Romaneio getRomaneioEntity() {
        return romaneio;
    }
    
}

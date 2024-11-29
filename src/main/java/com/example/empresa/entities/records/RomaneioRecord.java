package com.example.empresa.entities.records;

import java.util.List;

import com.example.empresa.entities.Codigo;

public record RomaneioRecord(
    List<Codigo> codigos,
    String status,
    String linkDownload,
    String codigoUid,
    int base,
    int entregador,
    int funcionario,
    int empresa,
    int cidade
) {}

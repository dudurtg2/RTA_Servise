package com.example.empresa.controllers.records;

import java.util.List;

import com.example.empresa.entities.Codigo;

public record RomaneioRecord(
    List<Codigo> codigos,
    String linkDownload,
    String codigoUid,
    Long base,
    Long entregador,
    Long funcionario,
    Long empresa,
    List<Long> cidade
) {}

package com.example.empresa.entities.records;

public record RomaneioUpdateRecord(
    String ocorrencia,
    String dataFinal,
    String status,
    int entregador,
    int funcionario,
    int cidade,
    int empresa,
    int motorista
) {}

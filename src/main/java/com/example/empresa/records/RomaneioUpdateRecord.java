package com.example.empresa.records;

public record RomaneioUpdateRecord(
    String ocorrencia,
    String dataFinal,
    String status,
    Integer entregador,
    Integer funcionario,
    Integer cidade,
    Integer empresa,
    Integer motorista
) {}

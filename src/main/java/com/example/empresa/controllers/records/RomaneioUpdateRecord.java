package com.example.empresa.controllers.records;

import java.util.List;

public record RomaneioUpdateRecord(
    String ocorrencia,
    String dataFinal,
    String status,
    String linkImg,
    Integer entregador,
    Integer funcionario,
    List<Integer> cidade,
    Integer empresa,
    Integer motorista
) {}

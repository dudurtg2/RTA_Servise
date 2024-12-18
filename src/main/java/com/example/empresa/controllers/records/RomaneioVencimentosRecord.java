package com.example.empresa.controllers.records;

public record RomaneioVencimentosRecord(
    int vencido,
    int vencendoHoje,
    int vencendoAmanha,
    int vencendoDepois
) {}

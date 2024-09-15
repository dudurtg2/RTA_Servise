package com.example.empresa.interfaces;

import com.example.empresa.entities.Empresa;

import java.util.List;

public interface IEmpresaRepository {
    List<Empresa> buscarTodos();
    Empresa buscarPorId(int id);
    Empresa gravar(Empresa empresa);
    Empresa atualizar(int id, Empresa empresaAtualizada);
    void excluir(int id);
}

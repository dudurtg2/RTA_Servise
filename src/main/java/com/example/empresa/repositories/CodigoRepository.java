package com.example.empresa.repositories;

import com.example.empresa.entities.Empresa;
import com.example.empresa.interfaces.ISystemRTARepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CodigoRepository implements ISystemRTARepository {

    @Override
    public List<Empresa> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public Empresa buscarPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public Empresa gravar(Empresa empresa) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gravar'");
    }

    @Override
    public Empresa atualizar(int id, Empresa empresaAtualizada) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void excluir(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

   
}

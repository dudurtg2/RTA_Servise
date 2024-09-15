package com.example.empresa.repositories;

import com.example.empresa.entities.Empresa; 
import com.example.empresa.interfaces.IEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaRepository {

    @Autowired
    private IEmpresaRepository empresaRepository;

    public List<Empresa> buscarTodos() {
        return empresaRepository.findAll();
    }

    public Empresa buscarPorId(int id) {
        Optional<Empresa> empresa = empresaRepository.findById(id);
        return empresa.orElse(null);
    }

    public Empresa gravar(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public Empresa atualizar(int id, Empresa empresaAtualizada) {
        Optional<Empresa> empresaExistente = empresaRepository.findById(id);
        if (empresaExistente.isPresent()) {
            Empresa empresa = empresaExistente.get();
            empresa.setNome(empresaAtualizada.getNome());
            empresa.setCnpj(empresaAtualizada.getCnpj());
            return empresaRepository.save(empresa);
        }
        return null;
    }

    public void excluir(int id) {
        empresaRepository.deleteById(id);
    }
}

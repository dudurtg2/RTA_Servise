package com.example.empresa.applications;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Codigo;
import com.example.empresa.entities.Romaneio;
import com.example.empresa.interfaces.IRomaneioRepository;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade {@link Romaneio}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade {@link Romaneio}.
 * Utiliza o repositório {@link IRomaneioRepository} para interagir com a base de dados.
 */
@Component
public class RomaneioApplication {
    private IRomaneioRepository romaneioRepository;

    /**
     * Construtor da classe RomaneioApplication.
     * 
     * @param romaneioRepository O repositório para a entidade {@link Romaneio}.
     */
    public RomaneioApplication(IRomaneioRepository romaneioRepository) {
        this.romaneioRepository = romaneioRepository;
    }
    
    /**
     * Recupera todas as instâncias da entidade {@link Romaneio}.
     * 
     * @return Uma lista com todas as instâncias de {@link Romaneio}.
     */
    public List<Romaneio> findAll() {
        return this.romaneioRepository.findAll();
    }

    /**
     * Recupera uma instância da entidade {@link Romaneio} com base no seu identificador único.
     * 
     * @param id O identificador da instância de {@link Romaneio}.
     * @return A instância de {@link Romaneio} correspondente ao id, ou null se não encontrado.
     */
    public Romaneio findById(int id) {
        return this.romaneioRepository.findById(id);
    }

    /**
     * Salva uma nova instância da entidade {@link Romaneio} no repositório.
     * Associa os códigos à instância de {@link Romaneio} antes de salvá-la.
     * 
     * @param romaneio A instância da entidade {@link Romaneio} a ser salva.
     * @return A instância salva de {@link Romaneio}.
     */
    public Romaneio save(Romaneio romaneio) {
        // Associa cada código ao romaneio antes de salvar
        for (Codigo codigo : romaneio.getCodigos()) {
            codigo.setRomaneio(romaneio);
        }


        
        return this.romaneioRepository.save(romaneio);
    }

    /**
     * Atualiza uma instância existente de {@link Romaneio}.
     * 
     * @param id O identificador da instância a ser atualizada.
     * @param romaneio A nova instância de {@link Romaneio} contendo as atualizações.
     * @return A instância atualizada de {@link Romaneio}, ou null se não encontrado.
     */
    public Romaneio update(int id, Romaneio romaneio) {
        Romaneio romaneioInDb = this.romaneioRepository.findById(id);

        if (romaneioInDb == null) {
            return null;
        }
        return this.romaneioRepository.update(id, romaneio);
    }

    /**
     * Exclui a instância da entidade {@link Romaneio} com base no seu identificador único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(int id) {
        this.romaneioRepository.deleteById(id);
    }

    public int getCount(String status) {
        List<Romaneio> romaneioAll = this.romaneioRepository.findAll();
        if (romaneioAll == null) return 0;

        int count = 0;

        for (Romaneio romaneio : romaneioAll) {
            if (romaneio.getSts().equals(status.toLowerCase())) {
                count++;
            }
        }
        return count;
    }
}

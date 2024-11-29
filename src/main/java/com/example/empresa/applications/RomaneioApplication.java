package com.example.empresa.applications;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.entities.Base;
import com.example.empresa.entities.Cidade;
import com.example.empresa.entities.Codigo;
import com.example.empresa.entities.Empresa;
import com.example.empresa.entities.Entregador;
import com.example.empresa.entities.Funcionario;
import com.example.empresa.entities.Motorista;
import com.example.empresa.entities.Romaneio;
import com.example.empresa.entities.records.RomaneioRecord;
import com.example.empresa.entities.records.RomaneioUpdateRecord;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.ICidadeRepository;
import com.example.empresa.interfaces.IEntregadorRepository;
import com.example.empresa.interfaces.IRomaneioRepository;

import jakarta.persistence.EntityNotFoundException;

import com.example.empresa.interfaces.IEmpresaRepository;
import com.example.empresa.interfaces.IFuncionarioRepository;
import com.example.empresa.interfaces.IMotoristaRepository;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade
 * {@link Romaneio}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade
 * {@link Romaneio}.
 * Utiliza o repositório {@link IRomaneioRepository} para interagir com a base
 * de dados.
 */
@Component
public class RomaneioApplication {
    private IRomaneioRepository romaneioRepository;
    private IEntregadorRepository entregadorRepository;
    private IEmpresaRepository empresaRepository;
    private IFuncionarioRepository funcionarioRepository;
    private IBaseRepository baseRepository;
    private ICidadeRepository cidadeRepository;
    private IMotoristaRepository motoristaRepository;

    /**
     * Construtor da classe RomaneioApplication.
     * 
     * @param romaneioRepository O repositório para a entidade {@link Romaneio}.
     */
    public RomaneioApplication(IRomaneioRepository romaneioRepository, IEntregadorRepository entregadorRepository,
            IEmpresaRepository empresaRepository, IFuncionarioRepository funcionarioRepository,
            IBaseRepository baseRepository, ICidadeRepository cidadeRepository,
            IMotoristaRepository motoristaRepository) {
        this.romaneioRepository = romaneioRepository;
        this.entregadorRepository = entregadorRepository;
        this.empresaRepository = empresaRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.baseRepository = baseRepository;
        this.cidadeRepository = cidadeRepository;
        this.motoristaRepository = motoristaRepository;
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
     * Recupera uma instância da entidade {@link Romaneio} com base no seu
     * identificador único.
     * 
     * @param id O identificador da instância de {@link Romaneio}.
     * @return A instância de {@link Romaneio} correspondente ao id, ou null se não
     *         encontrada.
     */
    public Romaneio findById(long id) {
        return this.romaneioRepository.findById(id);
    }

    /**
     * Salva uma nova instância da entidade {@link Romaneio} no repositório.
     * Antes de salvar, associa os códigos à instância de {@link Romaneio}.
     * 
     * @param romaneio A instância da entidade {@link Romaneio} a ser salva.
     * @return A instância salva de {@link Romaneio}.
     */
    public Romaneio save(RomaneioRecord romaneio) {

        if (romaneio == null || romaneio.codigos() == null)
            return null;

        Romaneio romaneioSave = new Romaneio();

        Entregador entregador = entregadorRepository.findById(romaneio.entregador());
        Funcionario funcionario = funcionarioRepository.findById(romaneio.funcionario());
        Empresa empresa = empresaRepository.findById(romaneio.empresa());
        Base base = baseRepository.findById(romaneio.base());
        Cidade cidade = cidadeRepository.findById(romaneio.cidade());

        if (entregador == null || funcionario == null || empresa == null || base == null || cidade == null)
            return null;

        romaneioSave.setData(LocalDate.now().toString());
        romaneioSave.setLinkDownload(romaneio.linkDownload());
        romaneioSave.setQuantidade(romaneio.codigos().size());
        romaneioSave.setCodigos(romaneio.codigos());
        romaneioSave.setCodigoUid(romaneio.codigoUid());
        romaneioSave.setSts("aguardando");

        romaneioSave.setEmpresa(empresa);
        romaneioSave.setEntregador(entregador);
        romaneioSave.setFuncionario(funcionario);
        romaneioSave.setBase(base);
        romaneioSave.setCidade(cidade);

        romaneioSave.setMotorista(null);
        romaneioSave.setDataFinal(null);
        romaneioSave.setOcorrencia(null);

        romaneioSave.getCodigos().forEach(codigo -> codigo.setRomaneio(romaneioSave));

        return this.romaneioRepository.save(romaneioSave);
    }

    /**
     * Atualiza um objeto {@link Romaneio} existente no sistema.
     * 
     * @param id     o identificador único do romaneio a ser atualizado.
     * @param romaneio o objeto {@link RomaneioUpdateRecord} com as atualizações.
     * @return o objeto {@link Romaneio} atualizado.
     * @throws EntityNotFoundException caso o identificador não seja encontrado.
     * @throws IllegalArgumentException caso o objeto {@link RomaneioUpdateRecord} seja nulo.
     */
    public Romaneio update(long id, RomaneioUpdateRecord romaneio) {
        Romaneio romaneioInDb = romaneioRepository.findById(id);
        if (romaneioInDb == null) {
            throw new EntityNotFoundException("Romaneio com id " + id + " não encontrado.");
        }

        if (romaneio == null) {
            throw new IllegalArgumentException("Objeto RomaneioUpdateRecord não pode ser nulo.");
        }

        updateData(romaneioInDb, romaneio);

        return this.romaneioRepository.update(id, romaneioInDb);
    }

    /**
     * Atualiza o objeto {@link Romaneio} existente com os dados fornecidos no
     * objeto {@link RomaneioUpdateRecord}.
     * 
     * @param romaneioInDb o objeto {@link Romaneio} existente no sistema.
     * @param romaneio     o objeto {@link RomaneioUpdateRecord} com as atualizações.
     */
    private void updateData(Romaneio romaneioInDb, RomaneioUpdateRecord romaneio) {
        if (romaneio.entregador() != null) {
            Entregador entregador = entregadorRepository.findById(romaneio.entregador());
            if (entregador == null) {
                throw new EntityNotFoundException("Entregador com id " + romaneio.entregador() + " não encontrado.");
            }
            romaneioInDb.setEntregador(entregador);
        }

        if (romaneio.funcionario() != null) {
            Funcionario funcionario = funcionarioRepository.findById(romaneio.funcionario());
            if (funcionario == null) {
                throw new EntityNotFoundException("Funcionário com id " + romaneio.funcionario() + " não encontrado.");
            }
            romaneioInDb.setFuncionario(funcionario);
        }

        if (romaneio.empresa() != null) {
            Empresa empresa = empresaRepository.findById(romaneio.empresa());
            if (empresa == null) {
                throw new EntityNotFoundException("Empresa com id " + romaneio.empresa() + " não encontrada.");
            }
            romaneioInDb.setEmpresa(empresa);
        }

        if (romaneio.cidade() != null) {
            Cidade cidade = cidadeRepository.findById(romaneio.cidade());
            if (cidade == null) {
                throw new EntityNotFoundException("Cidade com id " + romaneio.cidade() + " não encontrada.");
            }
            romaneioInDb.setCidade(cidade);
        }

        if (romaneio.motorista() != null) {
            if (romaneio.motorista() == 0) {
                romaneioInDb.setMotorista(null);
            } else {
                Motorista motorista = motoristaRepository.findById(romaneio.motorista());
                if (motorista == null) {
                    throw new EntityNotFoundException("Motorista com id " + romaneio.motorista() + " não encontrado.");
                }
                romaneioInDb.setMotorista(motorista);
            } 
        }

        romaneioInDb.setSts(romaneio.status() != null ? romaneio.status() : romaneioInDb.getSts());
        romaneioInDb.setOcorrencia(romaneio.ocorrencia() != null ? romaneio.ocorrencia() : romaneioInDb.getOcorrencia());
        romaneioInDb.setDataFinal(romaneio.dataFinal() != null ? romaneio.dataFinal() : romaneioInDb.getDataFinal());
    }

    /**
     * Exclui a instância da entidade {@link Romaneio} com base no seu identificador
     * único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(long id) {
        this.romaneioRepository.deleteById(id);
    }

    /**
     * Conta o número de instâncias da entidade {@link Romaneio} com um status
     * específico.
     * Realiza uma busca em todas as instâncias e verifica se o status corresponde
     * ao informado.
     * 
     * @param status O status utilizado como critério de filtragem.
     * @return O número de instâncias que possuem o status informado.
     */
    public int getCount(String status) {
        List<Romaneio> romaneioAll = this.romaneioRepository.findAll();
        if (romaneioAll == null)
            return 0;

        int count = 0;

        for (Romaneio romaneio : romaneioAll) {
            if (romaneio.getSts().equals(status.toLowerCase())) {
                count++;
            }
        }
        return count;
    }

    /**
     * Retorna uma lista de instâncias da entidade {@link Romaneio} com um status
     * específico.
     * 
     * @param sts O status utilizado como critério de filtragem.
     * @return Uma lista contendo todas as instâncias de {@link Romaneio} que
     *         possuem o status informado.
     */
    public List<Romaneio> findByStatus(String sts) {
        return this.romaneioRepository.findByStatus(sts);
    }
}

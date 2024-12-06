package com.example.empresa.applications;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.controllers.records.RomaneioRecord;
import com.example.empresa.controllers.records.RomaneioUpdateRecord;
import com.example.empresa.entities.Base;
import com.example.empresa.entities.Cidade;
import com.example.empresa.entities.Empresa;
import com.example.empresa.entities.Entregador;
import com.example.empresa.entities.Funcionario;
import com.example.empresa.entities.Motorista;
import com.example.empresa.entities.Romaneio;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.ICidadeRepository;
import com.example.empresa.interfaces.IEmpresaRepository;
import com.example.empresa.interfaces.IEntregadorRepository;
import com.example.empresa.interfaces.IFuncionarioRepository;
import com.example.empresa.interfaces.IMotoristaRepository;
import com.example.empresa.interfaces.IRomaneioRepository;
import com.example.empresa.services.CustomExceptionService;

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

        if (romaneio == null || romaneio.codigos() == null) throw new CustomExceptionService("Romaneio nullo ou sem códigos.", 400);

        Romaneio romaneioSave = new Romaneio();

        Entregador entregador = entregadorRepository.findById(romaneio.entregador());
        Funcionario funcionario = funcionarioRepository.findById(romaneio.funcionario());
        Empresa empresa = empresaRepository.findById(romaneio.empresa());
        Base base = baseRepository.findById(romaneio.base());
        Cidade cidade = cidadeRepository.findById(romaneio.cidade());

        this.validaRelacionamentos(romaneioSave, romaneio);

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
     * Valida as rela es de um {@link RomaneioRecord} verificando se as entidades
     * associadas
     * existem no banco de dados. Lan a um {@link CustomExceptionService} se alguma
     * das entidades n o for encontrada.
     *
     * @param romaneioInDb o objeto {@link Romaneio} existente no banco de dados.
     * @param romaneio     o objeto {@link RomaneioRecord} contendo os dados a serem
     *                     validados.
     * @throws CustomExceptionService se alguma entidade associada (Entregador,
     *                                Funcion rio, Empresa, Base, Cidade)
     *                                n o for encontrada no banco de dados.
     */
    private void validaRelacionamentos(Romaneio romaneioInDb, RomaneioRecord romaneio) {
        Entregador entregador = entregadorRepository.findById(romaneio.entregador());
        Funcionario funcionario = funcionarioRepository.findById(romaneio.funcionario());
        Empresa empresa = empresaRepository.findById(romaneio.empresa());
        Base base = baseRepository.findById(romaneio.base());
        Cidade cidade = cidadeRepository.findById(romaneio.cidade());

        if (entregador == null) {
            throw new CustomExceptionService("Entregador com id " + romaneio.entregador() + " não encontrado.", 404);
        }

        if (funcionario == null) {
            throw new CustomExceptionService("Funcionário com id " + romaneio.funcionario() + " não encontrado.", 404);
        }

        if (empresa == null) {
            throw new CustomExceptionService("Empresa com id " + romaneio.empresa() + " não encontrada.", 404);
        }

        if (base == null) {
            throw new CustomExceptionService("Base com id " + romaneio.base() + " não encontrada.", 404);
        }

        if (cidade == null) {
            throw new CustomExceptionService("Cidade com id " + romaneio.cidade() + " não encontrada.", 404);
        }
    }

    /**
     * Atualiza um objeto {@link Romaneio} existente no sistema.
     * 
     * @param id       o identificador único do romaneio a ser atualizado.
     * @param romaneio o objeto {@link RomaneioUpdateRecord} com as atualizações.
     * @return o objeto {@link Romaneio} atualizado.
     * @throws CustomExceptionService   caso o identificador não seja encontrado.
     * @throws IllegalArgumentException caso o objeto {@link RomaneioUpdateRecord}
     *                                  seja nulo.
     */
    public Romaneio update(long id, RomaneioUpdateRecord romaneio) {
        Romaneio romaneioInDb = romaneioRepository.findById(id);

        if (romaneio == null) {
            throw new CustomExceptionService("Objeto RomaneioUpdateRecord não pode ser nulo.", 400);
        }

        updateData(romaneioInDb, romaneio);

        return this.romaneioRepository.update(id, romaneioInDb);
    }

    public Romaneio update(String codigo, RomaneioUpdateRecord romaneio) {
        Romaneio romaneioInDb = romaneioRepository.findByCodigoUid(codigo);

        if (romaneio == null) {
            throw new CustomExceptionService("Objeto RomaneioUpdateRecord não pode ser nulo.", 400);
        }

        updateData(romaneioInDb, romaneio);

        return this.romaneioRepository.update(romaneioInDb.getId(), romaneioInDb);
    }

    /**
     * Atualiza o objeto {@link Romaneio} existente com os dados fornecidos no
     * objeto {@link RomaneioUpdateRecord}.
     * 
     * @param romaneioInDb o objeto {@link Romaneio} existente no sistema.
     * @param romaneio     o objeto {@link RomaneioUpdateRecord} com as
     *                     atualizações.
     */
    private void updateData(Romaneio romaneioInDb, RomaneioUpdateRecord romaneio) {
        validaCampos(romaneioInDb, romaneio);

        romaneioInDb.setSts(romaneio.status() != null ? romaneio.status() : romaneioInDb.getSts());
        romaneioInDb
                .setOcorrencia(romaneio.ocorrencia() != null ? romaneio.ocorrencia() : romaneioInDb.getOcorrencia());
        romaneioInDb.setDataFinal(romaneio.dataFinal() != null ? romaneio.dataFinal() : romaneioInDb.getDataFinal());
    }

    /**
     * Valida os campos do objeto {@link RomaneioUpdateRecord} antes de realizar
     * a atualização do objeto {@link Romaneio} existente no sistema.
     * 
     * @param romaneioInDb o objeto {@link Romaneio} existente no sistema.
     * @param romaneio     o objeto {@link RomaneioUpdateRecord} com as
     *                     atualizações.
     * @throws CustomExceptionService caso o identificador de alguma entidade
     *                                associada (Entregador, Funcion rio,
     *                                Empresa, Cidade, Motorista) n o seja
     *                                encontrado.
     */
    private void validaCampos(Romaneio romaneioInDb, RomaneioUpdateRecord romaneio) {
        if (romaneio.entregador() != null) {
            Entregador entregador = entregadorRepository.findById(romaneio.entregador());
            if (entregador == null) {
                throw new CustomExceptionService("Entregador com id " + romaneio.entregador() + " não encontrado.",
                        404);
            }
            romaneioInDb.setEntregador(entregador);
        }

        if (romaneio.funcionario() != null) {
            Funcionario funcionario = funcionarioRepository.findById(romaneio.funcionario());
            if (funcionario == null) {
                throw new CustomExceptionService("Funcionário com id " + romaneio.funcionario() + " não encontrado.",
                        404);
            }
            romaneioInDb.setFuncionario(funcionario);
        }

        if (romaneio.empresa() != null) {
            Empresa empresa = empresaRepository.findById(romaneio.empresa());
            if (empresa == null) {
                throw new CustomExceptionService("Empresa com id " + romaneio.empresa() + " não encontrada.", 404);
            }
            romaneioInDb.setEmpresa(empresa);
        }

        if (romaneio.cidade() != null) {
            Cidade cidade = cidadeRepository.findById(romaneio.cidade());
            if (cidade == null) {
                throw new CustomExceptionService("Cidade com id " + romaneio.cidade() + " não encontrada.", 404);
            }
            romaneioInDb.setCidade(cidade);
        }

        if (romaneio.motorista() != null) {
            if (romaneio.motorista() == 0) {
                romaneioInDb.setMotorista(null);
            } else {
                Motorista motorista = motoristaRepository.findById(romaneio.motorista());
                if (motorista == null) {
                    throw new CustomExceptionService("Motorista com id " + romaneio.motorista() + " não encontrado.",
                            404);
                }
                romaneioInDb.setMotorista(motorista);
            }
        }
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
    public int getCountForStatus(String status) {
        return this.romaneioRepository.findByStatus(status).size() > 0 ? this.romaneioRepository.findByStatus(status).size() : 0;
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

    /**
     * Retorna uma lista de instâncias da entidade {@link Romaneio} que cont m um
     * motorista com o identificador único especificado.
     * 
     * @param motorista O identificador do motorista utilizado como critério de
     *                   filtragem.
     * @return Uma lista contendo todas as instâncias de {@link Romaneio} que
     *         cont m o motorista especificado.
     */
    public List<Romaneio> findByMotorista(Long motorista) {
        return this.romaneioRepository.findByMotorista(this.motoristaRepository.findById(motorista));
    }

    /**
     * Retorna uma lista de instâncias da entidade {@link Romaneio} que cont m
     * um entregador com o identificador único especificado.
     * 
     * @param entregador O identificador do entregador utilizado como critério de
     *                   filtragem.
     * @return Uma lista contendo todas as instâncias de {@link Romaneio} que
     *         cont m o entregador especificado.
     */
    public List<Romaneio> findByEntregador(Long entregador) {
        return this.romaneioRepository.findByEntregador(this.entregadorRepository.findById(entregador));
    }

    /**
     * Recupera uma inst ncia da entidade {@link Romaneio} com base no seu c digo
     *  nico.
     * 
     * @param codigoUid O c digo  nico da inst ncia da entidade {@link Romaneio}.
     * @return A inst ncia de {@link Romaneio} correspondente ao c digo  nico
     *         informado, ou null se n o encontrada.
     */
    public Romaneio findByCodigoUid(String codigoUid) {
        return this.romaneioRepository.findByCodigoUid(codigoUid);
    }

}

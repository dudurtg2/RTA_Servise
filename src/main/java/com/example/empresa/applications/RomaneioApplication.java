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
import com.example.empresa.interfaces.IEmpresaRepository;
import com.example.empresa.interfaces.IFuncionarioRepository;
import com.example.empresa.interfaces.IMotoristaRepository;

/**
 * Classe responsável pela lógica de aplicação relacionada à entidade {@link Romaneio}.
 * Fornece métodos para consultar, salvar, atualizar e excluir dados da entidade {@link Romaneio}.
 * Utiliza o repositório {@link IRomaneioRepository} para interagir com a base de dados.
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
    public RomaneioApplication(IRomaneioRepository romaneioRepository, IEntregadorRepository entregadorRepository, IEmpresaRepository empresaRepository, IFuncionarioRepository funcionarioRepository, IBaseRepository baseRepository, ICidadeRepository cidadeRepository, IMotoristaRepository motoristaRepository) {
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
     * Recupera uma instância da entidade {@link Romaneio} com base no seu identificador único.
     * 
     * @param id O identificador da instância de {@link Romaneio}.
     * @return A instância de {@link Romaneio} correspondente ao id, ou null se não encontrada.
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
        
        if (romaneio == null || romaneio.codigos() == null) return null;

        Romaneio romaneioSave = new Romaneio();

        Entregador entregador = entregadorRepository.findById(romaneio.entregador());
        Funcionario funcionario = funcionarioRepository.findById(romaneio.funcionario());
        Empresa empresa = empresaRepository.findById(romaneio.empresa());
        Base base = baseRepository.findById(romaneio.base());
        Cidade cidade = cidadeRepository.findById(romaneio.cidade());
        
        if (entregador == null || funcionario == null || empresa == null || base == null || cidade == null) return null;

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
     * Atualiza uma instância existente de {@link Romaneio}.
     * Verifica se a instância com o identificador fornecido existe antes de atualizá-la.
     * 
     * @param id O identificador da instância a ser atualizada.
     * @param romaneio A nova instância de {@link Romaneio} contendo as atualizações.
     * @return A instância atualizada de {@link Romaneio}, ou null se a instância não for encontrada.
     */
    public Romaneio update(long id, RomaneioUpdateRecord romaneio) {
        if (romaneio == null) return null;
        
        Romaneio romaneioInDb = this.romaneioRepository.findById(id);
        if (romaneioInDb == null) return null;

        Entregador entregador = entregadorRepository.findById(romaneio.entregador());
        Funcionario funcionario = funcionarioRepository.findById(romaneio.funcionario());
        Empresa empresa = empresaRepository.findById(romaneio.empresa());
        Cidade cidade = cidadeRepository.findById(romaneio.cidade());
        Motorista motorista = motoristaRepository.findById(romaneio.motorista());

        if (empresa == null || funcionario == null || entregador == null || cidade == null) return null;
       
        romaneioInDb.setEmpresa(empresa != null ? empresa : romaneioInDb.getEmpresa());
        romaneioInDb.setMotorista(motorista != null ? motorista : romaneioInDb.getMotorista());
        romaneioInDb.setEntregador(entregador != null ? entregador : romaneioInDb.getEntregador());
        romaneioInDb.setFuncionario(funcionario != null ? funcionario : romaneioInDb.getFuncionario());
        romaneioInDb.setCidade(cidade != null ? cidade : romaneioInDb.getCidade());

        romaneioInDb.setSts(romaneio.status() != null ? romaneio.status() : romaneioInDb.getSts());
        romaneioInDb.setOcorrencia(romaneio.ocorrencia() != null ? romaneio.ocorrencia() : romaneioInDb.getOcorrencia());
        romaneioInDb.setDataFinal(romaneio.dataFinal() != null ? romaneio.dataFinal() : romaneioInDb.getDataFinal());

        romaneioInDb.setData(romaneioInDb.getData());
        romaneioInDb.setBase(romaneioInDb.getBase());
        romaneioInDb.setCodigos(romaneioInDb.getCodigos());
        romaneioInDb.setCodigoUid(romaneioInDb.getCodigoUid());
        romaneioInDb.setLinkDownload(romaneioInDb.getLinkDownload());
        romaneioInDb.setQuantidade(romaneioInDb.getQuantidade());

        return this.romaneioRepository.update(id, romaneioInDb);
    }

    /**
     * Exclui a instância da entidade {@link Romaneio} com base no seu identificador único.
     * 
     * @param id O identificador da instância a ser excluída.
     */
    public void deleteById(long id) {
        this.romaneioRepository.deleteById(id);
    }

    /**
     * Conta o número de instâncias da entidade {@link Romaneio} com um status específico.
     * Realiza uma busca em todas as instâncias e verifica se o status corresponde ao informado.
     * 
     * @param status O status utilizado como critério de filtragem.
     * @return O número de instâncias que possuem o status informado.
     */
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

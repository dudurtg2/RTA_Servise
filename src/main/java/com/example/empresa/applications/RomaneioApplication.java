package com.example.empresa.applications;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.empresa.controllers.records.RomaneioRecord;
import com.example.empresa.controllers.records.RomaneioResponceFinalizadoRecord;
import com.example.empresa.controllers.records.RomaneioUpdateRecord;
import com.example.empresa.controllers.records.RomaneioVencimentosRecord;
import com.example.empresa.entities.Base;
import com.example.empresa.entities.Cidade;
import com.example.empresa.entities.Empresa;
import com.example.empresa.entities.Entregador;
import com.example.empresa.entities.Funcionario;
import com.example.empresa.entities.Motorista;
import com.example.empresa.entities.Romaneio;
import com.example.empresa.interfaces.IBaseRepository;
import com.example.empresa.interfaces.ICidadeRepository;
import com.example.empresa.interfaces.ICodigoRepository;
import com.example.empresa.interfaces.IEmpresaRepository;
import com.example.empresa.interfaces.IEntregadorRepository;
import com.example.empresa.interfaces.IFuncionarioRepository;
import com.example.empresa.interfaces.IMotoristaRepository;
import com.example.empresa.interfaces.IRomaneioRepository;
import com.example.empresa.services.ErrorException;
import com.example.empresa.services.GoogleDriveService;

@Component
public class RomaneioApplication {

    private IRomaneioRepository romaneioRepository;
    private IEntregadorRepository entregadorRepository;
    private IEmpresaRepository empresaRepository;
    private IFuncionarioRepository funcionarioRepository;
    private IBaseRepository baseRepository;
    private ICidadeRepository cidadeRepository;
    private IMotoristaRepository motoristaRepository;
    private ICodigoRepository codigoRepository;
    private GoogleDriveService googleDriveService;

    public RomaneioApplication(IRomaneioRepository romaneioRepository, IEntregadorRepository entregadorRepository,
            IEmpresaRepository empresaRepository, IFuncionarioRepository funcionarioRepository,
            IBaseRepository baseRepository, ICidadeRepository cidadeRepository,
            IMotoristaRepository motoristaRepository, ICodigoRepository codigoRepository,
            GoogleDriveService googleDriveService) {
        this.romaneioRepository = romaneioRepository;
        this.entregadorRepository = entregadorRepository;
        this.empresaRepository = empresaRepository;
        this.funcionarioRepository = funcionarioRepository;
        this.baseRepository = baseRepository;
        this.cidadeRepository = cidadeRepository;
        this.motoristaRepository = motoristaRepository;
        this.codigoRepository = codigoRepository;
        this.googleDriveService = googleDriveService;
    }

    public List<Romaneio> findAll() {
        return this.romaneioRepository.findAll();
    }

    public RomaneioVencimentosRecord getVencimentos() {
        int vencidos = 0;
        int vencendoHoje = 0;
        int vencendoAmanha = 0;
        int vencendoDepois = 0;

        LocalDate hoje = LocalDate.now();
        LocalDate amanha = hoje.plusDays(1);
        LocalDate depoisDeAmanha = hoje.plusDays(2);

        for (Romaneio romaneio : this.romaneioRepository.findAll()) {
            if (romaneio.getSts().equals("aguardando")) {
                LocalDate dataRomaneio = LocalDate.parse(romaneio.getData()).plusDays(3);

                if (dataRomaneio.isEqual(hoje)) {
                    vencendoHoje++;
                } else if (dataRomaneio.isEqual(amanha)) {
                    vencendoAmanha++;
                } else if (dataRomaneio.isAfter(depoisDeAmanha) || dataRomaneio.isEqual(depoisDeAmanha)) {
                    vencendoDepois++;
                } else if (dataRomaneio.isBefore(hoje)) {
                    vencidos++;
                }
            }
        }

        return new RomaneioVencimentosRecord(vencidos, vencendoHoje, vencendoAmanha, vencendoDepois);
    }

    

    public Romaneio findById(long id) {
        return this.romaneioRepository.findById(id);
    }

    public Romaneio save(RomaneioRecord romaneio) {
        if (romaneio == null || romaneio.codigos() == null) {
            throw new ErrorException("Romaneio nullo ou sem códigos.", 400);
        }

        Romaneio romaneioSave = new Romaneio();

        this.validaRelacionamentos(romaneioSave, romaneio);

        Entregador entregador = entregadorRepository.findById(romaneio.entregador());
        Funcionario funcionario = funcionarioRepository.findById(romaneio.funcionario());
        Empresa empresa = empresaRepository.findById(romaneio.empresa());
        Base base = baseRepository.findById(romaneio.base());

        List<Cidade> cidade = new ArrayList<>();

        if (romaneio.cidade() != null) {
            for (long idCidade : romaneio.cidade()) {
                cidade.add(cidadeRepository.findById(idCidade));
            }
        }

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

    private void validaRelacionamentos(Romaneio romaneioInDb, RomaneioRecord romaneio) {
        Entregador entregador = entregadorRepository.findById(romaneio.entregador());
        Funcionario funcionario = funcionarioRepository.findById(romaneio.funcionario());
        Empresa empresa = empresaRepository.findById(romaneio.empresa());
        Base base = baseRepository.findById(romaneio.base());
        List<Cidade> cidade = new ArrayList<>();

        if (romaneio.cidade() != null) {
            for (long idCidade : romaneio.cidade()) {
                cidade.add(cidadeRepository.findById(idCidade));
            }
        }

        if (entregador == null) {
            throw new ErrorException("Entregador com id " + romaneio.entregador() + " não encontrado.", 404);
        }

        if (funcionario == null) {
            throw new ErrorException("Funcionário com id " + romaneio.funcionario() + " não encontrado.", 404);
        }

        if (empresa == null) {
            throw new ErrorException("Empresa com id " + romaneio.empresa() + " não encontrada.", 404);
        }

        if (base == null) {
            throw new ErrorException("Base com id " + romaneio.base() + " não encontrada.", 404);
        }

        for (Cidade c : cidade) {
            if (c == null) {
                throw new ErrorException("Cidade com id " + romaneio.cidade() + " não encontrada.", 404);
            }
        }

    }

    public Romaneio update(long id, RomaneioUpdateRecord romaneio) {
        Romaneio romaneioInDb = romaneioRepository.findById(id);

        if (romaneio == null) {
            throw new ErrorException("Objeto RomaneioUpdateRecord não pode ser nulo.", 400);
        }

        updateData(romaneioInDb, romaneio);

        return this.romaneioRepository.update(id, romaneioInDb);
    }

    public Romaneio update(String codigo, RomaneioUpdateRecord romaneio) {
        Romaneio romaneioInDb = romaneioRepository.findByCodigoUid(codigo);

        if (romaneio == null) {
            throw new ErrorException("Objeto RomaneioUpdateRecord não pode ser nulo.", 400);
        }

        updateData(romaneioInDb, romaneio);

        return this.romaneioRepository.update(romaneioInDb.getId(), romaneioInDb);
    }

    private void updateData(Romaneio romaneioInDb, RomaneioUpdateRecord romaneio) {
        if (romaneioInDb.getSts().equals("finalizado") && romaneio.linkImg() == null)
            throw new ErrorException("Romaneio finalizado.", 400);
        validaCampos(romaneioInDb, romaneio);

        romaneioInDb.setSts(romaneio.status() != null ? romaneio.status() : romaneioInDb.getSts());
        romaneioInDb.setDataFinal(romaneio.dataFinal() != null ? romaneio.dataFinal() : romaneioInDb.getDataFinal());

        romaneioInDb.setLinkDownloadImg(
                romaneio.linkImg() != null ? romaneio.linkImg() : romaneioInDb.getLinkDownloadImg());

        romaneioInDb.setOcorrencia(romaneio.ocorrencia() != null ? romaneio.ocorrencia() : romaneioInDb.getOcorrencia());
        romaneioInDb.setDataFinal(romaneio.dataFinal() != null ? romaneio.dataFinal() : romaneioInDb.getDataFinal());
    }

    private void validaCampos(Romaneio romaneioInDb, RomaneioUpdateRecord romaneio) {
        if (romaneio.entregador() != null) {
            Entregador entregador = entregadorRepository.findById(romaneio.entregador());
            if (entregador == null) {
                throw new ErrorException("Entregador com id " + romaneio.entregador() + " não encontrado.",
                        404);
            }
            romaneioInDb.setEntregador(entregador);

        }

        if (romaneio.funcionario() != null) {
            Funcionario funcionario = funcionarioRepository.findById(romaneio.funcionario());
            if (funcionario == null) {
                throw new ErrorException("Funcionário com id " + romaneio.funcionario() + " não encontrado.",
                        404);
            }
            romaneioInDb.setFuncionario(funcionario);
        }

        if (romaneio.empresa() != null) {
            Empresa empresa = empresaRepository.findById(romaneio.empresa());
            if (empresa == null) {
                throw new ErrorException("Empresa com id " + romaneio.empresa() + " não encontrada.", 404);
            }
            romaneioInDb.setEmpresa(empresa);
        }

        if (romaneio.cidade() != null) {
            List<Cidade> cidades = new ArrayList<>();

            for (long idCidade : romaneio.cidade()) {
                Cidade cidade = cidadeRepository.findById(idCidade);
                if (cidade == null) {
                    throw new ErrorException("Cidade com id " + idCidade + " não encontrada.", 404);
                }
                cidades.add(cidade);
            }
            romaneioInDb.setCidade(cidades);
        }

        if (romaneio.motorista() != null) {
            if (romaneio.motorista() == 0) {
                romaneioInDb.setMotorista(null);
            } else {
                Motorista motorista = motoristaRepository.findById(romaneio.motorista());
                if (motorista == null) {
                    throw new ErrorException("Motorista com id " + romaneio.motorista() + " não encontrado.",
                            404);
                }
                romaneioInDb.setMotorista(motorista);
            }
        }
    }

    public void deleteById(long id) {
        this.romaneioRepository.deleteById(id);
    }

    public int getCountForStatus(String status) {
        return this.romaneioRepository.findByStatus(status).size() > 0
                ? this.romaneioRepository.findByStatus(status).size()
                : 0;
    }

    public int getCountCodigosStsAll(String status) {
        List<Romaneio> romaneios = this.romaneioRepository.findByStatus(status);
        int count = 0;
        for (Romaneio romaneio : romaneios) {
            count += romaneio.getCodigos().size();
        }
        return count;
    }

    public List<RomaneioResponceFinalizadoRecord> getFinishedAll() {
        List<RomaneioResponceFinalizadoRecord> romaneios = new ArrayList<>();
        for (Romaneio romaneio : this.romaneioRepository.findByStatus("finalizado")) {
            String local = "";
            int count = 0;
            for (Cidade cidade : romaneio.getCidade()) {
                if (count > 0) {
                    local +=  ", ";
                }
                local += cidade.getNome();
                count++;
            }
            romaneios.add(
                    new RomaneioResponceFinalizadoRecord(
                            romaneio.getCodigoUid(),
                            romaneio.getMotorista().getNome(),
                            romaneio.getDataFinal(),
                            local
                            )
                        );

        }
        return romaneios;
    }

    public List<Romaneio> findByStatus(String sts) {
        return this.romaneioRepository.findByStatus(sts);
    }

    public List<Romaneio> findByMotorista(Long motorista) {
        return this.romaneioRepository.findByMotorista(this.motoristaRepository.findById(motorista));
    }

    public List<Romaneio> findByMotoristaSts(Long motorista, String sts) {
        List<Romaneio> romaneios = new ArrayList<>();
        for (Romaneio romaneio : this.romaneioRepository
                .findByMotorista(this.motoristaRepository.findById(motorista))) {
            if (romaneio.getSts().equals(sts)) {
                romaneios.add(romaneio);
            }
        }
        return romaneios;
    }

    public List<Romaneio> findByEntregador(Long entregador) {
        return this.romaneioRepository.findByEntregador(this.entregadorRepository.findById(entregador));
    }

    public Romaneio findByCodigoUid(String codigoUid) {
        return this.romaneioRepository.findByCodigoUid(codigoUid);
    }

    public Romaneio findBySearch(String seach) {
        Romaneio romaneio = this.romaneioRepository.findByCodigoUid(seach);
        if (romaneio != null) {
            return romaneio;
        }
        return this.romaneioRepository
                .findByCodigoUid(this.codigoRepository.findByCodigo(seach).getRomaneio().codigo());
    }

    public Romaneio uploadImage(String codigo, BufferedImage image) {
        Romaneio romaneio = this.romaneioRepository.findByCodigoUid(codigo);

        if (romaneio == null) throw new ErrorException("Romaneio nao encontrado.", 404);
        
        String publicLink = "";
        String local = "";

        int count = 0;
        for (Cidade cidade : romaneio.getCidade()) {
            if (count > 0) {
                local +=  ", ";
            }
            local += cidade.getNome();
            count++;
        }

        try {
            publicLink = googleDriveService.uploadImageToDrive(image, romaneio.getCodigoUid(), local);
        } catch (Exception e) {
            throw new ErrorException("ESSE E UM ERRO: " + e.getMessage(), 500);
        }
        
        romaneio.setLinkDownloadImg(publicLink);

        return this.romaneioRepository.save(romaneio);
    }
}

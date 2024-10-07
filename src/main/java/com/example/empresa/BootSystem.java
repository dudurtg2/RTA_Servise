package com.example.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.empresa.entities.Cidade;
import com.example.empresa.entities.Empresa;
import com.example.empresa.entities.Regiao;
import com.example.empresa.facades.CidadeFacade;
import com.example.empresa.facades.EmpresaFacade;
import com.example.empresa.facades.RegiaoFacade;

@SpringBootApplication
public class BootSystem{

	public static void main(String[] args) {
		SpringApplication.run(BootSystem.class, args);
	}

	private EmpresaFacade empresafacade;
	private CidadeFacade cidadeFacade;
	private RegiaoFacade regiaoFacade;

	@Autowired
	public BootSystem(EmpresaFacade empresafacade, CidadeFacade cidadeFacade, RegiaoFacade regiaoFacade) {
		this.empresafacade = empresafacade;
		this.cidadeFacade = cidadeFacade;
		this.regiaoFacade = regiaoFacade;
	}

	@Bean
	public CommandLineRunner commandLineRunner(CidadeFacade cidadeFacade, RegiaoFacade regiaoFacade) {
		return runner -> {
			saveRegiao(regiaoFacade);
			saveCidade(cidadeFacade);
		};
	}
	private void saveRegiao(RegiaoFacade regiaoFacade) {
		Regiao regiao = new Regiao("Regiao de Teste");
		regiaoFacade.save(regiao);
	}
	private void saveCidade(CidadeFacade cidadeFacade) {
		Regiao regiao = regiaoFacade.findById(1);
		Cidade cidade = new Cidade("Cidade de Teste", "0000000", regiao);
		cidadeFacade.save(cidade);
	}

}

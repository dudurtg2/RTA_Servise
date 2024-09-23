package com.example.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.empresa.entities.Empresa;
import com.example.empresa.facades.EmpresaFacade;

@SpringBootApplication
public class BootSystem{

	public static void main(String[] args) {
		SpringApplication.run(BootSystem.class, args);
	}

	@Autowired
	private EmpresaFacade empresafacade;

	@Bean
	public CommandLineRunner commandLineRunner(EmpresaFacade empresafacade) {
		return runner -> {
			saveEmpresa( empresafacade);
		};
	}

	private void saveEmpresa(EmpresaFacade empresafacade) {
		Empresa empresa = new Empresa("Empresa de Teste", "12345678901234");
		empresafacade.save(empresa);
	}


}

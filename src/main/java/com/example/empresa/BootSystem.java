package com.example.empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.empresa.entities.Base;
import com.example.empresa.entities.emuns.UserRole;
import com.example.empresa.facades.BaseFacade;
import com.example.empresa.facades.UsersFacade;
import com.example.empresa.security.DTO.RegisterDTO;

@SpringBootApplication
public class BootSystem{
	private BaseFacade baseFacade;
	private UsersFacade usersFacade;

	@Autowired
	public BootSystem(BaseFacade baseFacade, UsersFacade usersFacade) {
		this.baseFacade = baseFacade;
		this.usersFacade = usersFacade;
		addBase();
		addAdminUser();
	}

	public static void main(String[] args) {
		SpringApplication.run(BootSystem.class, args);
	}

	private void addBase() {
		try {
			if (baseFacade.findById(1) != null) {
				return;
			}
			Base base = new Base();
			base.setNome("Lc Transportes - HUB01");
			base.setEndereco("R. Rosendo Firmino Ferreira, 53 - Sim, Feira de Santana - BA, 44076-696");
			baseFacade.save(base);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void addAdminUser() {
		try {
			if (usersFacade.findById(1) != null) {
				return;
			}
			RegisterDTO user = new RegisterDTO("Carlos Eduardo Oliveira Savegnago", "DUdu@147", UserRole.ADMIN, "carlos.e.o.savegnago@gmail.com", "75981099613", "09027268541", 1, null);
			usersFacade.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
 	
}

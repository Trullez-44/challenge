package com.andyWork.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import com.andyWork.challenge.domain.service.PlatoService;
import com.andyWork.challenge.persistence.entity.Plato;

@SpringBootApplication
public class ChallengeApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext contexto = SpringApplication.run(ChallengeApplication.class, args);
		PlatoService platoService = contexto.getBean(PlatoService.class);

		// CREACION DE PLATO
		Plato plato = new Plato();
		plato.setNombre("Empanada");
		plato.setDescripcion("Empanada Deliciosas");
		plato.setPrecio(1500);
		platoService.savePlato(plato);


		// METODOS
		System.out.println(platoService.getAll());

		// platoService.deletePlato(2);
	// platoService.getById(1);	
		// platoService.updatePlato(plato);
		System.out.println(platoService.getAll());
		
	}

}

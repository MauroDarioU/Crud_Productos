// Agrupalas clases relacionadas dentro de este paquete
package com.universidad.crud;

// Lanza la aplicacion.
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication

//  Habilita el escaneo y creación de los repositorios JPA.
@EnableJpaRepositories

// Activa el soporte para las anotaciones JPA
@EnableJpaAuditing

public class CrudApplication {

	// Indica que es la clase principal
	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

}

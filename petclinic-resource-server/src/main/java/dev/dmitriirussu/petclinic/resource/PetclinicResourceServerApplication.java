package dev.dmitriirussu.petclinic.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PetclinicResourceServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(PetclinicResourceServerApplication.class, args);
	}
}

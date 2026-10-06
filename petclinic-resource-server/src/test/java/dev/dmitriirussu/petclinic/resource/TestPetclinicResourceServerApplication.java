package dev.dmitriirussu.petclinic.resource;

import org.springframework.boot.SpringApplication;

public class TestPetclinicResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.from(PetclinicResourceServerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

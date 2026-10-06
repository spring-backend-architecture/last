package dev.dmitriirussu.petclinic.auth;

import org.springframework.boot.SpringApplication;

public class TestPetclinicAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.from(PetclinicAuthServerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

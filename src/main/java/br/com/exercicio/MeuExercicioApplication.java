package br.com.exercicio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - Construindo Sistemas Com Boas Práticas,Spring security,JWT,Docker",
				version = "1.0",
				description = "API para cadastro de pessoas.",
				contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
)
public class MeuExercicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeuExercicioApplication.class, args);
	}

}

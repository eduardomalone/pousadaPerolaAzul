package com.projeto.pousada;

import com.projeto.pousada.domain.Funcionario;
import com.projeto.pousada.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@ComponentScan
public class PousadaPerolaAzulApplication implements CommandLineRunner {

	@Autowired
	FuncionarioRepository funcionarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(PousadaPerolaAzulApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Funcionario func1 = new Funcionario(null,"Richard", "Gerente", 1000.00, "1010", "7070");
		Funcionario func2 = new Funcionario(null,"Richard", "Gerente", 1000.00, "1010", "7070");

		funcionarioRepository.saveAll(Arrays.asList(func1, func2));

	}
}

package com.projeto.pousada;

import com.projeto.pousada.domain.Categoria;
import com.projeto.pousada.domain.Consumo;
import com.projeto.pousada.domain.Funcionario;
import com.projeto.pousada.domain.Produto;
import com.projeto.pousada.repositories.CategoriaRepository;
import com.projeto.pousada.repositories.ConsumoRepository;
import com.projeto.pousada.repositories.FuncionarioRepository;
import com.projeto.pousada.repositories.ProdutoRepository;
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

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	ConsumoRepository consumoRepository;

	@Autowired
	CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(PousadaPerolaAzulApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Funcionario func1 = new Funcionario(null,"Richard", "Gerente", 1000.00, "1010", "7070");
		Funcionario func2 = new Funcionario(null,"Richard", "Gerente", 1000.00, "1010", "7070");

		Categoria cat1 = new Categoria(null, "Refeicão");
		Categoria cat2 = new Categoria(null, "Serviço de Quarto");

		Produto prod1 = new Produto(null,"cafe da manhã", 5.00);
		Produto prod2 = new Produto(null,"almoco", 35.00);
		Produto prod3 = new Produto(null,"toalhas extras", 15.00);

		Consumo consumo1 = new Consumo(null, "cafe da manha", "hoje as 10:00", 2);
		Consumo consumo2 = new Consumo(null, "almoco", "hoje as 13:00", 2);
		Consumo consumo3 = new Consumo(null, "jantar", "hoje as 22:00", 1);

		cat1.getListaProdutos().addAll(Arrays.asList(prod1,prod2));
		cat2.getListaProdutos().addAll(Arrays.asList(prod3));

		prod1.getListaCategorias().addAll(Arrays.asList(cat1));
		prod2.getListaCategorias().addAll(Arrays.asList(cat1,cat2));
		prod3.getListaCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		funcionarioRepository.saveAll(Arrays.asList(func1, func2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2));
		consumoRepository.saveAll(Arrays.asList(consumo1, consumo2));

	}
}

package com.projeto.pousada;

import com.projeto.pousada.domain.*;
import com.projeto.pousada.repositories.*;
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

	@Autowired
	 EstadoRepository estadoRepository;

	@Autowired
	 CidadeRepository cidadeRepository;

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

		Estado est1 = new Estado(null, "São Paulo;");
		Estado est2 = new Estado(null, "Minas Gerais");

		Cidade cid1 = new Cidade(null, "Peruibe", est1);
		Cidade cid2 = new Cidade(null, "Santos", est1);
		Cidade cid3 = new Cidade(null, "Uberlandia", est2);

		est1.getCidades().addAll(Arrays.asList(cid3));
		est2.getCidades().addAll(Arrays.asList(cid2));
		est2.getCidades().addAll(Arrays.asList(cid1));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

	}
}

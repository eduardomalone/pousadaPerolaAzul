package com.projeto.pousada;

import com.projeto.pousada.domain.*;
import com.projeto.pousada.domain.enums.EstadoPagamento;
import com.projeto.pousada.domain.enums.TipoCliente;
import com.projeto.pousada.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
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

	@Autowired
	EnderecoRepository enderecoRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	HospedagemRepository hospedagemRepository;

	@Autowired
	PagamentoRepository pagamentoRepository;

	@Autowired
	AposentoRepository aposentoRepository;

	@Autowired
	ContaRepository contaRepository;

	@Autowired
	ItemHospedagemRepository itemHospedagemRepository;

	public static void main(String[] args) {
		SpringApplication.run(PousadaPerolaAzulApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Funcionario func1 = new Funcionario(null,"Richard", "Gerente", 1000.00, "1010", "7070");
		Funcionario func2 = new Funcionario(null,"Richard", "Gerente", 1000.00, "1010", "7070");

		Categoria cat1 = new Categoria(null, "Refeicão");
		Categoria cat2 = new Categoria(null, "Serviço de Quarto");



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

		Cliente cli1 = new Cliente(null, "Eduardo Lucio", "eduardo@teste.com.br", "53535353", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("707070","707071"));
		Endereco end1 = new Endereco(null, "Rua dos bobos"," numero zero", "", "qualquer um", "11080000", cli1, cid1);
		Endereco end2 = new Endereco(null, "Rua dos sonhos"," nao existe", "", "tao tao distante", "11080000", cli1, cid2);
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));

		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));

		Aposento apo1 = new Aposento(null, "Quarto 1", 100.00, 1);
		Aposento apo2 = new Aposento(null, "Quarto 2", 120.00, 2);

		aposentoRepository.saveAll(Arrays.asList(apo1, apo2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Hospedagem hosp1 = new Hospedagem(null, sdf.parse("30/09/2017 10:32"), sdf.parse("02/10/2017 10:32"), cli1);
		Hospedagem hosp2 = new Hospedagem(null, sdf.parse("30/10/2017 10:32"), sdf.parse("02/11/2017 10:32"), cli1);

		Pagamento pagto1 =  new PagamentoComCartao(null, EstadoPagamento.QUITADO, hosp1, 2);
		hosp1.setPagamento(pagto1);

		Pagamento pagto2 =  new PagamentoDepositoTransferencia(null, EstadoPagamento.QUITADO, hosp2 ,sdf.parse("30/09/2017 10:32"),
				sdf.parse("30/09/2017 10:32"));
		hosp2.setPagamento(pagto2);

		cli1.getHospedagens().addAll(Arrays.asList(hosp1,hosp2));

		Produto prod1 = new Produto(null,"cafe da manhã", 5.00);
		Produto prod2 = new Produto(null,"almoco", 35.00);
		Produto prod3 = new Produto(null,"toalhas extras", 15.00);

		//Conta conta1 = new Conta(null, 10.00, true, hosp1);
		//Conta conta2 = new Conta(null, 20.00, false, hosp2);



		//Consumo consumo1 = new Consumo(null, "cafe da manha", "hoje as 10:00", 2, conta1);
		//Consumo consumo2 = new Consumo(null, "almoco", "hoje as 13:00", 2, conta2);
		//Consumo consumo3 = new Consumo(null, "jantar", "hoje as 22:00", 1, conta1);

		cat1.getListaProdutos().addAll(Arrays.asList(prod1,prod2));
		cat2.getListaProdutos().addAll(Arrays.asList(prod3));

		prod1.getListaCategorias().addAll(Arrays.asList(cat1));
		prod2.getListaCategorias().addAll(Arrays.asList(cat1,cat2));
		prod3.getListaCategorias().addAll(Arrays.asList(cat1));

		//ItemHospedagem(Aposento aposento, Hospedagem hospedagem, Double desconto, int qtd, Double preco)
		ItemHospedagem item1 = new ItemHospedagem(apo1, hosp1, 0.00, 1, 100.00);
		ItemHospedagem item2 = new ItemHospedagem(apo2, hosp2, 0.00, 1, 100.00);
		ItemHospedagem item3 = new ItemHospedagem(apo2, hosp2, 0.00, 1, 100.00);

		hosp1.getItens().addAll(Arrays.asList(item1));
		hosp2.getItens().addAll(Arrays.asList(item2, item3));

		apo1.getItens().addAll(Arrays.asList(item1));
		apo2.getItens().addAll(Arrays.asList(item2, item3));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		funcionarioRepository.saveAll(Arrays.asList(func1, func2));
		produtoRepository.saveAll(Arrays.asList(prod1, prod2));
		//contaRepository.saveAll(Arrays.asList(conta1, conta2));
		//consumoRepository.saveAll(Arrays.asList(consumo1, consumo2));


		hospedagemRepository.saveAll(Arrays.asList(hosp1, hosp2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		itemHospedagemRepository.saveAll(Arrays.asList(item1, item2, item3));

	}
}

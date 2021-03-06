package br.com.goappa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.goappa.domains.Categoria;
import br.com.goappa.domains.Cidade;
import br.com.goappa.domains.Endereco;
import br.com.goappa.domains.Estado;
import br.com.goappa.domains.Produto;
import br.com.goappa.repositories.CategoriaRepository;
import br.com.goappa.repositories.CidadeRepository;
import br.com.goappa.repositories.EnderecoRepository;
import br.com.goappa.repositories.EstadoRepository;
import br.com.goappa.repositories.ProdutoRepository;

@SpringBootApplication
public class GoAppaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GoAppaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Pizza");
		Categoria cat2 = new Categoria(null, "Bebida");
		Categoria cat3 = new Categoria(null, "Temaki");

		Produto p1 = new Produto(null, "Pizza de Calabresa", 45.50, "Pizza de Calabresa com cebola e muçarela");
		Produto p2 = new Produto(null, "Coca Cola 2L", 10.00, "Refrigerante de cola 2L");
		Produto p3 = new Produto(null, "Temaki Philadelphia", 15.00, "Temaki de salmão com cream cheese");
		Produto p4 = new Produto(null, "Pizza de Frango com Catupiry", 30.00, "Pizza de Frango com Catupiry");
		
		p1.getImagens()
				.addAll(Arrays.asList(
						"https://www.sabornamesa.com.br/media/k2/items/cache/513d7a0ab11e38f7bd117d760146fed3_L.jpg",
						"https://www.receiteria.com.br/wp-content/uploads/receitas-de-pizza-de-calabresa-6.jpg"));
		p2.getImagens().addAll(Arrays.asList(
				"https://carrefourbr.vtexassets.com/arquivos/ids/191885-800-auto?width=800&height=auto&aspect=true"));
		p3.getImagens().addAll(Arrays.asList("https://coisasdojapao.com/wp-content/uploads/2017/02/temaki-salmao.jpg"));
		p4.getImagens().add("http://lanchoneteoficinadosabor.com.br/static/uploads/produto/ab9d9b7fbe37faf433195260233c2613.jpg");
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p4));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		cat3.getProdutos().addAll(Arrays.asList(p3));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().add(cat2);
		p3.getCategorias().add(cat3);
		p4.getCategorias().add(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		Estado e1 = new Estado(null, "Pará");
		Estado e2 = new Estado(null, "Rio de Janeiro");
		
		Cidade c1 = new Cidade(null, "Belém", e1);
		Cidade c2 = new Cidade(null, "Rio de Janeiro", e2);
		Cidade c3 = new Cidade(null, "Marituba", e1);
		
		e1.getCidades().addAll(Arrays.asList(c1, c3));
		e2.getCidades().addAll(Arrays.asList(c2));
		
		estadoRepository.saveAll(Arrays.asList(e1, e2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		
		//Endereco end1 = new Endereco(null, "Rua Joaquim gomes ferreira", "Condado de york", "Vargem Grande", "22785660", )

	}

}

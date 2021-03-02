package br.com.goappa;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.goappa.domains.Categoria;
import br.com.goappa.repositories.CategoriaRepository;

@SpringBootApplication
public class GoAppaApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GoAppaApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria (null, "Pizza");
		Categoria cat2 = new Categoria (null, "Bebida");
		Categoria cat3 = new Categoria (null, "Sushi");
		Categoria cat4 = new Categoria (null, "Bebida");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		
	}

}

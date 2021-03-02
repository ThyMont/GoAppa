package br.com.goappa.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.goappa.domains.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResourse {
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Categoria> listar() {
		List<Categoria> lista = new ArrayList<>();
		Categoria cat1 = new Categoria(1, "Informática");
		Categoria cat2 = new Categoria(2, "Escritório");
		lista.addAll(Arrays.asList(cat1, cat2));
		return lista;
	}
}

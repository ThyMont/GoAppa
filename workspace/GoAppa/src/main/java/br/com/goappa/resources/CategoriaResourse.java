package br.com.goappa.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResourse {
	
	@RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "<h1>Isto é um teste</h1>";
	}
}

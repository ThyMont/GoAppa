package br.com.goappa.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.goappa.domains.Cidade;
import br.com.goappa.repositories.CidadeRepository;
import br.com.goappa.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	@Autowired
	private CidadeRepository repo;

	public Cidade find(Integer id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}

}

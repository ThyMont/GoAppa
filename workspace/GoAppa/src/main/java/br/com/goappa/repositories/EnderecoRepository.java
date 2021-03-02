package br.com.goappa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.goappa.domains.Categoria;

@Repository
public interface EnderecoRepository  extends JpaRepository<Categoria, Integer>{

}

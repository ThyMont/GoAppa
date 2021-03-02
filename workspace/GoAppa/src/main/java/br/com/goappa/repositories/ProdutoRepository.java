package br.com.goappa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.goappa.domains.Produto;

@Repository
public interface ProdutoRepository  extends JpaRepository<Produto, Integer>{

}

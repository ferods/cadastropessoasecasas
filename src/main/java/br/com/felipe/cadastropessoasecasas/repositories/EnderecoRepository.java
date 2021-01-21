package br.com.felipe.cadastropessoasecasas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.felipe.cadastropessoasecasas.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}

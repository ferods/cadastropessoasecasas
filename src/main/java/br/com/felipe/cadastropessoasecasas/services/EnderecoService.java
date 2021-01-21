package br.com.felipe.cadastropessoasecasas.services;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.felipe.cadastropessoasecasas.model.Endereco;
import br.com.felipe.cadastropessoasecasas.model.Pessoa;
import br.com.felipe.cadastropessoasecasas.repositories.PessoaRepository;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoEndereco;

@Service
public class EnderecoService {

	@Autowired
	private PessoaRepository pessoaRepository;

	@Transactional
	public ResponseEntity<Endereco> salvarEndereco(RequisicaoEndereco requisicao, UriComponentsBuilder builder) {
		
		Optional<Pessoa> pessoaOpt = pessoaRepository.findById(requisicao.getPessoaId());	
		
		if(!pessoaOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Pessoa pessoa = pessoaOpt.get();
		Endereco endereco = requisicao.toEndereco();
		endereco.setPessoa(pessoa);
		pessoa.adicionarEndereco(endereco);
		pessoaRepository.save(pessoa);
		
		URI uri = builder.path("/api/endereco/id").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(endereco);
	}
	
	

}

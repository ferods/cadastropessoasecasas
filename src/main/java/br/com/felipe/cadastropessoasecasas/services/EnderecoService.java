package br.com.felipe.cadastropessoasecasas.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.felipe.cadastropessoasecasas.dtos.EnderecoDTO;
import br.com.felipe.cadastropessoasecasas.model.Endereco;
import br.com.felipe.cadastropessoasecasas.model.Pessoa;
import br.com.felipe.cadastropessoasecasas.repositories.EnderecoRepository;
import br.com.felipe.cadastropessoasecasas.repositories.PessoaRepository;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoEndereco;

@Service
public class EnderecoService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Transactional
	public ResponseEntity<EnderecoDTO> salvarEndereco(RequisicaoEndereco requisicao, UriComponentsBuilder builder) {
		
		System.out.println(requisicao);
		
		Optional<Pessoa> pessoaOpt = pessoaRepository.findById(requisicao.getPessoaCpf());	
		
		if(!pessoaOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Pessoa pessoa = pessoaOpt.get();
		Endereco endereco = requisicao.toEndereco();
		endereco.setPessoa(pessoa);
		pessoa.adicionarEndereco(endereco);
		pessoaRepository.save(pessoa);
		
		URI uri = builder.path("/api/endereco/id").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDTO(endereco));
	}

	public EnderecoDTO getEnderecoDTO() {
		return new EnderecoDTO();
	}

	public List<EnderecoDTO> getListaEnderecoDTO() {		
		return EnderecoDTO.converter(enderecoRepository.findAll());
	}
	
	

}

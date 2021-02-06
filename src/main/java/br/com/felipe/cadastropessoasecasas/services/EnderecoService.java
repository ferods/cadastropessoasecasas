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
import br.com.felipe.cadastropessoasecasas.dtos.EnderecoDetalhesDTO;
import br.com.felipe.cadastropessoasecasas.model.Endereco;
import br.com.felipe.cadastropessoasecasas.model.Pessoa;
import br.com.felipe.cadastropessoasecasas.repositories.EnderecoRepository;
import br.com.felipe.cadastropessoasecasas.repositories.PessoaRepository;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoAlterarEndereco;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoCodigoChave;
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
		
		if(!pessoaOpt.isPresent()) return ResponseEntity.notFound().build();
		
		Pessoa pessoa = pessoaOpt.get();
		Endereco endereco = requisicao.toEndereco();
		endereco.setPessoa(pessoa);
		pessoa.adicionarEndereco(endereco);
		pessoaRepository.save(pessoa);
		
		URI uri = builder.path("/api/endereco/id").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDTO(endereco));
	}

	public ResponseEntity<EnderecoDTO> getEnderecoDTO() {
		return ResponseEntity.ok(new EnderecoDTO());
	}
	
	public ResponseEntity<EnderecoDetalhesDTO> getDetalhes(Long id) {
		Optional<Endereco> findById = enderecoRepository.findById(id);
		if(!findById.isPresent()) { return ResponseEntity.notFound().build();}
		Endereco endereco = findById.get();
		return ResponseEntity.ok(new EnderecoDetalhesDTO(endereco));
	}

	public List<EnderecoDTO> getListaEnderecoDTO() {		
		return EnderecoDTO.converter(enderecoRepository.findAll());
	}

	public ResponseEntity<EnderecoDTO> formularioAlterarEndereco(Long id) {
		Optional<Endereco> findById = enderecoRepository.findById(id);		
		if(!findById.isPresent()) return ResponseEntity.notFound().build();		
		return ResponseEntity.ok(new EnderecoDTO(findById.get()));
	}

	@Transactional
	public ResponseEntity<EnderecoDTO> alterar(RequisicaoAlterarEndereco requisicao) {
		Endereco endereco = requisicao.alterar(enderecoRepository);
		return ResponseEntity.ok(new EnderecoDTO(enderecoRepository.save(endereco)));
	}

	@Transactional
	public ResponseEntity<?> deletarEndereco(Long id) {
		enderecoRepository.deleteById(id);
		return ResponseEntity.accepted().build();
	}

	
	
	

}

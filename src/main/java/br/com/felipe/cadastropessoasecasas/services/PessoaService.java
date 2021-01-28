package br.com.felipe.cadastropessoasecasas.services;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.felipe.cadastropessoasecasas.dtos.PessoaDTO;
import br.com.felipe.cadastropessoasecasas.dtos.PessoaDetalhesDTO;
import br.com.felipe.cadastropessoasecasas.dtos.TelefoneDTO;
import br.com.felipe.cadastropessoasecasas.model.Pessoa;
import br.com.felipe.cadastropessoasecasas.repositories.PessoaRepository;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoAlterarPessoa;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoNovaPessoa;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	//lista de pessoas
	public List<PessoaDTO> getPessoas() {		
		return PessoaDTO.converter(pessoaRepository.findAll());
	}


	//detalhes de uma pessoa com seus enderecos
	public ResponseEntity<PessoaDetalhesDTO> obterDetalhes(Long pessoaCpf) {		
		
        Optional<Pessoa> pessoaOpt = pessoaRepository.findById(pessoaCpf);	
        
        if(!pessoaOpt.isPresent()) {
        	return ResponseEntity.notFound().build();
        }
		
		return ResponseEntity.ok().body(new PessoaDetalhesDTO(pessoaOpt.get()));
		
	}


	public ResponseEntity<PessoaDTO> cadastrarPessoa() {		
		return ResponseEntity.ok(new PessoaDTO(new TelefoneDTO()));
	}


	public ResponseEntity<PessoaDTO> cadastrar(RequisicaoNovaPessoa requisicao, UriComponentsBuilder builder) {
		System.out.println(requisicao);
		Pessoa pessoa = requisicao.toPessoa();	
		System.out.println(pessoa);
		pessoaRepository.save(pessoa);
		URI uri = builder.path("/api/pessoa/id").buildAndExpand(pessoa.getCpf()).toUri();
		return ResponseEntity.created(uri).body(new PessoaDTO(pessoa));
	}


	public ResponseEntity<PessoaDTO> formularioAlterarPessoa(Long cpf) {
		Optional<Pessoa> pessoaOpt = pessoaRepository.findById(cpf);
		
		if(!pessoaOpt.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(new PessoaDTO(pessoaOpt.get()));
	}


	public ResponseEntity<PessoaDTO> alterar(RequisicaoAlterarPessoa requisicao) {
		System.out.println(requisicao);
		Pessoa pessoa = requisicao.alterar(pessoaRepository);		
		return ResponseEntity.ok().body(new PessoaDTO(pessoa));
	}

}

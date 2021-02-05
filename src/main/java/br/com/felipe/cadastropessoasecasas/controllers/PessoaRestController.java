package br.com.felipe.cadastropessoasecasas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.felipe.cadastropessoasecasas.dtos.PessoaDTO;
import br.com.felipe.cadastropessoasecasas.dtos.PessoaDetalhesDTO;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoAlterarPessoa;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoNovaPessoa;
import br.com.felipe.cadastropessoasecasas.services.PessoaService;

@RestController 
@RequestMapping("/api/pessoas")
public class PessoaRestController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping("/cadastrar")
	public ResponseEntity<PessoaDTO> cadastrar(@RequestBody RequisicaoNovaPessoa requisicao, UriComponentsBuilder builder){
		return pessoaService.cadastrar(requisicao, builder);
	}
	
	
	@GetMapping("/novocadastro")
	public ResponseEntity<PessoaDTO> cadastrarPessoa(){
		return pessoaService.cadastrarPessoa();
	}

	@GetMapping
	public List<PessoaDTO> getPessoas(){
		return pessoaService.getPessoas();
	}
	
	@GetMapping("/{cpf}")
	public ResponseEntity<PessoaDetalhesDTO> detalhes(@PathVariable("cpf") Long pessoaCpf) {
		return pessoaService.obterDetalhes(pessoaCpf);
	}
	
	
	//metodos responsaveis pela alteração de dados já no banco
	
	@PutMapping("/alterar")
	public ResponseEntity<PessoaDTO> alterarPessoa(@RequestBody RequisicaoAlterarPessoa requisicao){
		return pessoaService.alterar(requisicao);		
	}
	
	@GetMapping("/alterar/{cpf}")
	public ResponseEntity<PessoaDTO> formularioAlterarPessoa(@PathVariable Long cpf){
		return pessoaService.formularioAlterarPessoa(cpf);
	}
	
	
	

}

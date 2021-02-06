package br.com.felipe.cadastropessoasecasas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.felipe.cadastropessoasecasas.dtos.EnderecoDTO;
import br.com.felipe.cadastropessoasecasas.dtos.EnderecoDetalhesDTO;
import br.com.felipe.cadastropessoasecasas.dtos.PessoaDTO;
import br.com.felipe.cadastropessoasecasas.model.Endereco;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoAlterarEndereco;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoAlterarPessoa;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoCodigoChave;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoEndereco;
import br.com.felipe.cadastropessoasecasas.services.EnderecoService;

@RestController
@RequestMapping("/api/enderecos")
public class EnderecoRestController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	@GetMapping
	private List<EnderecoDTO> getListaEnderecoDTO(){
		return enderecoService.getListaEnderecoDTO();
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<EnderecoDetalhesDTO> getDetalhes(@PathVariable("id") Long id){
		return enderecoService.getDetalhes(id);
	}
	
	@GetMapping("/novo")
	private ResponseEntity<EnderecoDTO> getEnderecoDTO() {
		return enderecoService.getEnderecoDTO();
	}

	@PostMapping
	public ResponseEntity<EnderecoDTO> salvarEndereco(@RequestBody RequisicaoEndereco requisicao, UriComponentsBuilder builder){
		return enderecoService.salvarEndereco(requisicao, builder);
	}
	
	//metodos responsaveis pela alteração de dados já no banco
	
	@PutMapping("/alterar")
	public ResponseEntity<EnderecoDTO> alterarEndereco(@RequestBody RequisicaoAlterarEndereco requisicao){
		return enderecoService.alterar(requisicao);		
	}
	
	@GetMapping("/alterar/{id}")
	public ResponseEntity<EnderecoDTO> formularioAlterarPessoa(@PathVariable Long id){
		return enderecoService.formularioAlterarEndereco(id);
	}
	
	//metodos para deletar endereco
	
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<?> deletarEndereco(@PathVariable Long id){
		return enderecoService.deletarEndereco(id);		
	}

}

package br.com.felipe.cadastropessoasecasas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.felipe.cadastropessoasecasas.model.Endereco;
import br.com.felipe.cadastropessoasecasas.requisicoes.RequisicaoEndereco;
import br.com.felipe.cadastropessoasecasas.services.EnderecoService;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoRestController {
	
	@Autowired
	private EnderecoService enderecoService;

	@PostMapping
	public ResponseEntity<Endereco> salvarEndereco(@RequestBody RequisicaoEndereco requisicao, UriComponentsBuilder builder){
		return enderecoService.salvarEndereco(requisicao, builder);
	}

}

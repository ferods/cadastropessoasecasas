package br.com.felipe.cadastropessoasecasas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enderecos")
public class EnderecoController {
	
	@GetMapping("/novo")
	public String formulario() {
		return "endereco/formulario";
	}
	
	@GetMapping("/lista")
	public String getPaginaLista() {
		return "endereco/lista";
	}
	
	@GetMapping("/detalhes/{id}")
	public String getDetalhes() {
		return "endereco/detalhes";
	}
	
	@GetMapping("/alterar/{id}")
	public String getPaginaFormularioAlteracao() {
		return "endereco/formularioalteracao";	
	}

}

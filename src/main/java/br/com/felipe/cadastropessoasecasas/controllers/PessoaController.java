package br.com.felipe.cadastropessoasecasas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pessoas")
public class PessoaController {
	
	@GetMapping("/detalhes/{cpf}")
	public String detalhes() {
		return "pessoa/detalhes";
	}
	
	@GetMapping("/novo")
	public String formulario() {
		return "pessoa/formulario";
	}
	
	@GetMapping("/alterar/{id}")
	public String formularioAlteracao() {
		return "pessoa/formularioalteracao";
	}

}

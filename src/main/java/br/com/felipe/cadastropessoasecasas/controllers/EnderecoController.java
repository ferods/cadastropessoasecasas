package br.com.felipe.cadastropessoasecasas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/endereco")
public class EnderecoController {
	
	@GetMapping("/novo")
	public String formulario() {
		return "endereco/formulario";
	}

}

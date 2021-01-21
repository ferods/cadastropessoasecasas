package br.com.felipe.cadastropessoasecasas.dtos;

import java.util.List;
import java.util.stream.Collectors;

import br.com.felipe.cadastropessoasecasas.model.Pessoa;

public class PessoaDTO {

	private Long cpf;
	private String nome;
	private String email;
	private TelefoneDTO telefoneDTO;
	private Boolean envioRealizado = false;
	

	public PessoaDTO(Pessoa pessoa) {
		super();
		this.cpf = pessoa.getCpf();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.telefoneDTO = new TelefoneDTO(pessoa.getTelefone());				
	}
	
	public PessoaDTO(TelefoneDTO telefone) {
		this.telefoneDTO = telefone;
	}


	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public TelefoneDTO getTelefoneDTO() {
		return telefoneDTO;
	}
	
	public void setTelefoneDTO(TelefoneDTO telefoneDTO) {
		this.telefoneDTO = telefoneDTO;
	}
	
	public Boolean getEnvioRealizado() {
		return envioRealizado;
	}
	
	public void setEnvioRealizado(Boolean envioRealizado) {
		this.envioRealizado = envioRealizado;
	}

	public static List<PessoaDTO> converter(List<Pessoa> pessoas) {
		return pessoas.stream().map(PessoaDTO :: new).collect(Collectors.toList());
	}

}

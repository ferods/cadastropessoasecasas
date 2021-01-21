package br.com.felipe.cadastropessoasecasas.dtos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.felipe.cadastropessoasecasas.model.Pessoa;

public class PessoaDetalhesDTO {
	
	private Long cpf;
	private String nome;
	private String email;
	private TelefoneDTO telefoneDTO;
	private LocalDate dataEntrada = LocalDate.now();
	private List<EnderecoDTO> enderecosDTO = new ArrayList<EnderecoDTO>();
	

	public PessoaDetalhesDTO(Pessoa pessoa) {
		
		this.cpf = pessoa.getCpf();
		this.nome = pessoa.getNome();
		this.email = pessoa.getEmail();
		this.telefoneDTO = new TelefoneDTO(pessoa.getTelefone());
		this.dataEntrada = pessoa.getDataEntrada();
		enderecosDTO.addAll(pessoa.getEnderecos().stream().map(EnderecoDTO :: new).collect(Collectors.toList()));		
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

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	public List<EnderecoDTO> getEnderecosDTO() {
		return enderecosDTO;
	}
	
	public void setEnderecosDTO(List<EnderecoDTO> enderecosDTO) {
		this.enderecosDTO = enderecosDTO;
	}	

}

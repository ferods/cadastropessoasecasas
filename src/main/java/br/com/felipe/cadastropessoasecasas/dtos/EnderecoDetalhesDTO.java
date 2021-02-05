package br.com.felipe.cadastropessoasecasas.dtos;

import java.util.List;
import java.util.stream.Collectors;

import br.com.felipe.cadastropessoasecasas.model.Endereco;

public class EnderecoDetalhesDTO {

	private Long id;
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private Integer cep;
	private String cidade;
	private String uf;
	private PessoaDTO pessoaDTO;

	public EnderecoDetalhesDTO(Endereco endereco) {
		super();
		this.id = endereco.getId();
		this.logradouro = endereco.getLogradouro();
		this.numero = endereco.getNumero();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.cep = endereco.getCep();
		this.cidade = endereco.getCidade();
		this.uf = endereco.getUf().toString();
		this.pessoaDTO = new PessoaDTO(endereco.getPessoa());
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public PessoaDTO getPessoaDTO() {
		return pessoaDTO;
	}
	public void setPessoaDTO(PessoaDTO pessoaDTO) {
		this.pessoaDTO = pessoaDTO;
	}

	public static List<EnderecoDetalhesDTO> converter(List<Endereco> findAll) {
		return findAll.stream().map(EnderecoDetalhesDTO :: new).collect(Collectors.toList());
	}
	

	

}

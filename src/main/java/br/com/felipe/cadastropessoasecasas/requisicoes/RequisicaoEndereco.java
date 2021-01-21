package br.com.felipe.cadastropessoasecasas.requisicoes;

import br.com.felipe.cadastropessoasecasas.model.Endereco;
import br.com.felipe.cadastropessoasecasas.model.Uf;

public class RequisicaoEndereco {
	
	private String logradouro;
	private Integer numero;
	private String complemento;
	private String bairro;
	private Integer cep;
	private String cidade;
	private String uf;
	private Long pessoaId;
	
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
	public Long getPessoaId() {
		return pessoaId;
	}
	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}
	public Endereco toEndereco() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setCep(cep);
		endereco.setUf(Uf.valueOf(uf));
		return endereco;
	}
	
	
	

}

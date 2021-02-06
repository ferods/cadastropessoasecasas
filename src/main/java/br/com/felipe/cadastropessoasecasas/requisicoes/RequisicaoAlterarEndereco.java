package br.com.felipe.cadastropessoasecasas.requisicoes;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import br.com.felipe.cadastropessoasecasas.model.Endereco;
import br.com.felipe.cadastropessoasecasas.model.Uf;
import br.com.felipe.cadastropessoasecasas.repositories.EnderecoRepository;

public class RequisicaoAlterarEndereco {

	private String enderecoLogradouro;
	private Integer enderecoNumero;
	private String enderecoComplemento;
	private String enderecoBairro;
	private Integer enderecoCep;
	private String enderecoCidade;
	private String enderecoUf;
	private Long enderecoId;



	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}

	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}

	public Integer getEnderecoNumero() {
		return enderecoNumero;
	}

	public void setEnderecoNumero(Integer enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}

	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}

	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}

	public String getEnderecoBairro() {
		return enderecoBairro;
	}

	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}

	public Integer getEnderecoCep() {
		return enderecoCep;
	}

	public void setEnderecoCep(Integer enderecoCep) {
		this.enderecoCep = enderecoCep;
	}

	public String getEnderecoCidade() {
		return enderecoCidade;
	}

	public void setEnderecoCidade(String enderecoCidade) {
		this.enderecoCidade = enderecoCidade;
	}

	public String getEnderecoUf() {
		return enderecoUf;
	}

	public void setEnderecoUf(String enderecoUf) {
		this.enderecoUf = enderecoUf;
	}

	public Long getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Long enderecoId) {
		this.enderecoId = enderecoId;
	}

	public Endereco alterar(EnderecoRepository enderecoRepository) {
		
		System.out.println(this.enderecoId);

		Optional<Endereco> findById = enderecoRepository.findById(this.enderecoId);

		if (!findById.isPresent()) {
			throw new EntityNotFoundException();
		}

		Endereco endereco = findById.get();
		endereco.setLogradouro(this.enderecoLogradouro);
		endereco.setNumero(this.enderecoNumero);
		endereco.setComplemento(this.enderecoComplemento);
		endereco.setBairro(this.enderecoBairro);
		endereco.setCidade(this.enderecoCidade);
		endereco.setCep(this.enderecoCep);
		endereco.setUf(Uf.valueOf(this.enderecoUf.toUpperCase()));

		return endereco;
	}

}

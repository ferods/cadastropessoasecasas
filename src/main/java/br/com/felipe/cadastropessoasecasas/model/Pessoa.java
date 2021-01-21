package br.com.felipe.cadastropessoasecasas.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Pessoa {
	
	@Id
	private Long cpf;
	private String nome;
	private String email;
	@Embedded
	private Telefone telefone;
	private LocalDate dataEntrada = LocalDate.now();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoa")
	@JsonIgnore
	private List<Endereco> enderecos;
	
	
	public void adicionarEndereco(Endereco endereco) {
		enderecos.add(endereco);		
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
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public LocalDate getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


	@Override
	public String toString() {
		return "Pessoa [cpf=" + cpf + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone
				+ ", dataEntrada=" + dataEntrada + "]";
	}
	
	
	
	

}

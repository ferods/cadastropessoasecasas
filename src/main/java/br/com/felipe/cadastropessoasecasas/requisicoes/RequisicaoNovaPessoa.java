package br.com.felipe.cadastropessoasecasas.requisicoes;

import br.com.felipe.cadastropessoasecasas.model.Pessoa;
import br.com.felipe.cadastropessoasecasas.model.Telefone;

public class RequisicaoNovaPessoa {
	
	private Long pessoaCpf;
	private String pessoaNome;
	private String pessoaEmail;
	private String pessoaTelefoneResidencial;
	private String pessoaTelefoneCelular;
	
	
	public Long getPessoaCpf() {
		return pessoaCpf;
	}
	public void setPessoaCpf(Long pessoaCpf) {
		this.pessoaCpf = pessoaCpf;
	}
	public String getPessoaNome() {
		return pessoaNome;
	}
	public void setPessoaNome(String pessoaNome) {
		this.pessoaNome = pessoaNome;
	}
	public String getPessoaEmail() {
		return pessoaEmail;
	}
	public void setPessoaEmail(String pessoaEmail) {
		this.pessoaEmail = pessoaEmail;
	}
	public String getPessoaTelefoneResidencial() {
		return pessoaTelefoneResidencial;
	}
	public void setPessoaTelefoneResidencial(String pessoaTelefoneResidencial) {
		this.pessoaTelefoneResidencial = pessoaTelefoneResidencial;
	}
	public String getPessoaTelefoneCelular() {
		return pessoaTelefoneCelular;
	}
	public void setPessoaTelefoneCelular(String pessoaTelefoneCelular) {
		this.pessoaTelefoneCelular = pessoaTelefoneCelular;
	}
	public Pessoa toPessoa() {
		Pessoa pessoa = new Pessoa();
		pessoa.setCpf(this.pessoaCpf);
		pessoa.setNome(this.pessoaNome);
		pessoa.setEmail(this.pessoaEmail);
		
		Telefone telefone = new Telefone();
		telefone.setResidencial(this.pessoaTelefoneResidencial);
		telefone.setCelular(this.pessoaTelefoneCelular);
		
		pessoa.setTelefone(telefone);
		return pessoa;
	}
	
	@Override
	public String toString() {
		return "RequisicaoNovaPessoa [pessoaCpf=" + pessoaCpf + ", pessoaNome=" + pessoaNome + ", pessoaEmail="
				+ pessoaEmail + ", pessoaTelefoneResidencial=" + pessoaTelefoneResidencial
				 + ", pessoaTelefoneCelular="
				+ pessoaTelefoneCelular + "]";
	}
	
	
	
	
	
	

}

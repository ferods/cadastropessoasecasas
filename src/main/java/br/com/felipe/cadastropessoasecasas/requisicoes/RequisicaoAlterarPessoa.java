package br.com.felipe.cadastropessoasecasas.requisicoes;

import br.com.felipe.cadastropessoasecasas.model.Pessoa;
import br.com.felipe.cadastropessoasecasas.model.Telefone;
import br.com.felipe.cadastropessoasecasas.repositories.PessoaRepository;

public class RequisicaoAlterarPessoa {
	
	private Long pessoaCpf;
	private String atualizarPessoaNome;
	private String atualizarPessoaEmail;
	private String atualizarPessoaTelefoneResidencial;
	private String atualizarPessoaTelefoneCelular;
	
	public Long getPessoaCpf() {
		return pessoaCpf;
	}
	public void setPessoaCpf(Long pessoaCpf) {
		this.pessoaCpf = pessoaCpf;
	}
	public String getAtualizarPessoaNome() {
		return atualizarPessoaNome;
	}
	public void setAtualizarPessoaNome(String atualizarPessoaNome) {
		this.atualizarPessoaNome = atualizarPessoaNome;
	}
	public String getAtualizarPessoaEmail() {
		return atualizarPessoaEmail;
	}
	public void setAtualizarPessoaEmail(String atualizarPessoaEmail) {
		this.atualizarPessoaEmail = atualizarPessoaEmail;
	}
	public String getAtualizarPessoaTelefoneResidencial() {
		return atualizarPessoaTelefoneResidencial;
	}
	public void setAtualizarPessoaTelefoneResidencial(String atualizarPessoaTelefoneResidencial) {
		this.atualizarPessoaTelefoneResidencial = atualizarPessoaTelefoneResidencial;
	}
	public String getAtualizarPessoaTelefoneCelular() {
		return atualizarPessoaTelefoneCelular;
	}
	public void setAtualizarPessoaTelefoneCelular(String atualizarPessoaTelefoneCelular) {
		this.atualizarPessoaTelefoneCelular = atualizarPessoaTelefoneCelular;
	}
	
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "RequisicaoAlterarPessoa [pessoaCpf=" + pessoaCpf + ", atualizarPessoaNome=" + atualizarPessoaNome
				+ ", atualizarPessoaEmail=" + atualizarPessoaEmail + ", atualizarPessoaTelefoneResidencial="
				+ atualizarPessoaTelefoneResidencial + ", atualizarPessoaTelefoneCelular="
				+ atualizarPessoaTelefoneCelular + "]";
	}
	
	
	
	
	
	
	public Pessoa alterar(PessoaRepository repository) {
		
		Pessoa pessoa = repository.getOne(this.pessoaCpf);
		
		pessoa.setNome(this.atualizarPessoaNome);
		pessoa.setEmail(this.atualizarPessoaEmail);
		
		Telefone telefone = new Telefone();
		telefone.setResidencial(this.atualizarPessoaTelefoneResidencial);
		telefone.setCelular(this.atualizarPessoaTelefoneCelular);
		
		pessoa.setTelefone(telefone);		
		
		return repository.save(pessoa);
	}
	
	
	

}

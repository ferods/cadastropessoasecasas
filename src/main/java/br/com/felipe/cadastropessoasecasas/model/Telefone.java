package br.com.felipe.cadastropessoasecasas.model;

import javax.persistence.Embeddable;

@Embeddable
public class Telefone {
	
	private String residencial;
	private String celular;
	
	public String getResidencial() {
		return residencial;
	}
	public void setResidencial(String residencial) {
		this.residencial = residencial;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	

}

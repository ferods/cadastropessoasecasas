package br.com.felipe.cadastropessoasecasas.dtos;

import br.com.felipe.cadastropessoasecasas.model.Telefone;

public class TelefoneDTO {
	
	private String residencial;
	private String celular;
	private Boolean envioRealizado = false;
	
	public TelefoneDTO(Telefone telefone) {
		this.residencial = telefone.getResidencial();
		this.celular =  telefone.getCelular();
	}
	
	public TelefoneDTO() {}
	
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
	public Boolean getEnvioRealizado() {
		return envioRealizado;
	}
	public void setEnvioRealizado(Boolean envioRealizado) {
		this.envioRealizado = envioRealizado;
	}
	
	

}

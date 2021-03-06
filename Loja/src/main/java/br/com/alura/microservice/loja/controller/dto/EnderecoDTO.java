package br.com.alura.microservice.loja.controller.dto;

import lombok.Data;

@Data
public class EnderecoDTO {
	
	private String rua;
	
	private int numero;
	
	private String estado;

	@Override
	public String toString() {
		return "[rua=" + rua + ", numero=" + numero + ", estado=" + estado + "]";
	}
	
}

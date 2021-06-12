package br.com.alura.microservice.loja.controller.dto;

import java.util.List;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class CompraDTO {
	
	private List<ItemDaCompraDTO> itens;
	
	private EnderecoDTO endereco;
	
}

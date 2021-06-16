package br.com.alura.microservice.loja.model;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import lombok.Data;

@Data
public class Compra {
	
	private Long pedidoId;
	
	private Integer tempoDePreparo;
	
	private String enderecoDestino;
	
	
	public Compra(InfoPedidoDTO compra, CompraDTO compraDto) {
		this.pedidoId = compra.getId();
		this.tempoDePreparo = compra.getTempoDePreparo() ;
		this.enderecoDestino = compraDto.getEndereco().toString();
	}
	
}

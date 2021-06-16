package br.com.alura.microservice.loja.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.loja.client.FornecedorClient;
import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;
import br.com.alura.microservice.loja.dto.InfoPedidoDTO;
import br.com.alura.microservice.loja.model.Compra;

@Service
public class CompraService {
	
	private Logger LOG = LoggerFactory.getLogger(CompraService.class);
	//@Value("${app.url.fornecedor}")
	//private String fornecedor;
	
	//@Autowired
	//private RestTemplate client;
	
	@Autowired
	private FornecedorClient fornecedorClient;
	
	public Compra realizaCompra(CompraDTO compra) {
		
		/** comunicação com RestTemplate
		RestTemplate client = new RestTemplate();
		
		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
				fornecedor + compra.getEndereco().getEstado(), HttpMethod.GET, null, InfoFornecedorDTO.class);
		**/
		LOG.info("Solicitando as informações por estado " + compra.getEndereco().getEstado());
		InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());
		
		//System.out.println(exchange.getBody().getEndereco());
		LOG.info("Realizando o pedido de compra " + compra.getItens());
		InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
		
		//Compra compraSalva = new Compra(pedido, compra);
		
		return new Compra(pedido, compra);
		

	}

}

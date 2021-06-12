package br.com.alura.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.alura.microservice.loja.controller.dto.CompraDTO;
import br.com.alura.microservice.loja.dto.InfoFornecedorDTO;

@Service
public class CompraService {

	@Value("${app.url.fornecedor}")
	private String fornecedor;
	
	@Autowired
	private RestTemplate client;
	
	public void realizaCompra(CompraDTO compra) {

		//RestTemplate client = new RestTemplate();
		
		ResponseEntity<InfoFornecedorDTO> exchange = client.exchange(
				fornecedor + compra.getEndereco().getEstado(), HttpMethod.GET, null, InfoFornecedorDTO.class);

		System.out.println("->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + exchange.getBody().getEndereco());

	}

}

package com.renato.ecommerce_rabbit;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/produtos")
public class ProductController {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@PostMapping
	public ResponseEntity<?> realizarCompra (@RequestBody CompraDTO compraDTO) throws JsonProcessingException, AmqpException{
		
		amqpTemplate.convertAndSend("compra-exchange","compras-rout-key",objectMapper.writeValueAsString(compraDTO));
		return null;
		
	}
	
}

package com.renato.ecommerce_rabbit;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class EcommerceRabbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceRabbitApplication.class, args);
	}

}

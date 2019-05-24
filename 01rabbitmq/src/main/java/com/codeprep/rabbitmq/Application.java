package com.codeprep.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// below lines of code works only when a exchange named testExchange and a binding routing called testRouting is created pointing to q queue on RabbitMQ
//		rabbitTemplate.convertAndSend("testExchange","testRouting", "Hello after binding!");
		
		MessageDTO messageDTO = new MessageDTO();
		messageDTO.setId(1L);
		messageDTO.setMessage("Binary Message");
		rabbitTemplate.convertAndSend("testExchange","testRouting", messageDTO);
	}

}

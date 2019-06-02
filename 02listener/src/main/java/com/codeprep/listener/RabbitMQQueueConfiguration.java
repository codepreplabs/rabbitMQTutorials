package com.codeprep.listener;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQQueueConfiguration {

	// example 1 configuration for declaring a queue
	@Bean
	Queue exampleOneQueue() {
		return new Queue("testQueue1", true);
	}
	
	// example 2 configuration 
	@Bean
	Queue exampleTwoQueue() {
		return QueueBuilder.durable("testQueue2").autoDelete().exclusive().build();
	}
}

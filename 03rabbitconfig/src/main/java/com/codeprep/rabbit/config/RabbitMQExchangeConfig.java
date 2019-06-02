package com.codeprep.rabbit.config;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQExchangeConfig {

	// example 1
	@Bean
	Exchange exampleExchangeOne() {
		return new TopicExchange("exampleExchangeOne");
	}

	// example 2
	@Bean
	Exchange exampleExchnageTwo() {
		return ExchangeBuilder.directExchange("exampleExchangeTwo").autoDelete().internal().build();
	}
}

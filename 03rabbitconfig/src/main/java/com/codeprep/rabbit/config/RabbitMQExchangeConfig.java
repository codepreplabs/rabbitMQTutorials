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
	
	// example 3 fanout exchange
	@Bean
	Exchange exampleFanOutExchange() {
		return ExchangeBuilder.fanoutExchange("testFanoutExchange")
				.autoDelete()
				.durable(true)
				.internal()
				.build();
	}
	
	// example 4 headers exchange
	@Bean
	Exchange exampleHeadersExchange() {
		return ExchangeBuilder.headersExchange("testHeadersExchange")
				.internal()
				.durable(true)
				.ignoreDeclarationExceptions()
				.build();
	}
}

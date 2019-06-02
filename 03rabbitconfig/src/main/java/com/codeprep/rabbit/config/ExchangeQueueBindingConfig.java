package com.codeprep.rabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeQueueBindingConfig {
	
	@Autowired
	private CachingConnectionFactory connectionfactory;
	
	@Bean
	Exchange getSampleExchange() {
		return new TopicExchange("sampleExchange");
	}
	
	@Bean
	Queue getSampleQueue() {
		return new Queue("sampleQueue", true);
	}
	
/*	@Bean
	Binding applySampleBinding() {
		return new Binding("sampleQueue", Binding.DestinationType.QUEUE, "sampleExchange", "sample", null);
	}*/
	
	@Bean
	Binding applyBindingDecleratively() {
		return BindingBuilder
				.bind(getSampleQueue())
				.to(getSampleExchange())
				.with("sample")
				.noargs();
	}
	
	@Bean
	MessageListenerContainer messageListenerContainer() {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionfactory);
		simpleMessageListenerContainer.setQueues(getSampleQueue());
		simpleMessageListenerContainer.setMessageListener(new TestJavaConfigQueueListener());
		return simpleMessageListenerContainer;
	}
}

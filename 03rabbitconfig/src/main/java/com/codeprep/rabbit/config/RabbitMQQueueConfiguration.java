package com.codeprep.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
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
	
	@Bean
	CachingConnectionFactory connectionFactory() {
		
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory("localhost");
		cachingConnectionFactory.setUsername("guest");
		cachingConnectionFactory.setPassword("guest");
		return cachingConnectionFactory;
	}
	
	@Bean
	MessageListenerContainer getSampleQueueMessageListenerContainer() {
		SimpleMessageListenerContainer simpleMessageListenerContainer = new SimpleMessageListenerContainer();
		simpleMessageListenerContainer.setConnectionFactory(connectionFactory());
		simpleMessageListenerContainer.setQueues(exampleOneQueue());
		simpleMessageListenerContainer.setMessageListener(new TestQueueOneMessageListener());
		return simpleMessageListenerContainer;
	}
}

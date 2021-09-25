package com.kemalyanmaz.portfoliowork.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kemalyanmaz.portfoliowork.async.RoomCleanerListener;


public class AsyncConfig {

	private static final String QUEUE_NAME = "room-cleaner";
	private static final String EXCHANGE_NAME = "operations";
	
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_NAME,false);
	}
	
	@Bean
	public TopicExchange exchange() {
		return new TopicExchange(EXCHANGE_NAME);
	}
	
	@Bean
	public Binding bind(Queue queue,TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("landon.rooms.cleaner");
	}
	
	@Bean
	public MessageListenerAdapter listenerAdapter(RoomCleanerListener listener) {
		return new MessageListenerAdapter(listener,"receiveMessage");
	}

	@Bean
	public SimpleMessageListenerContainer container(ConnectionFactory factory, MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(factory);
		container.setQueueNames(QUEUE_NAME);
		container.setMessageListener(listenerAdapter);
		return container;
	}
}

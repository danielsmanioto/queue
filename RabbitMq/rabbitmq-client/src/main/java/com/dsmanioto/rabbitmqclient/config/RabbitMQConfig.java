package com.dsmanioto.rabbitmqclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Value("${dsmanioto.rabbitmq.queue}")
	private String queueName;

	@Value("${spring.rabbitmq.host}")
	private String host;

	public String getQueueName() {
		return queueName;
	}

	public String getHost() {
		return host;
	}
}

package com.dsmanioto.service;

import com.dsmanioto.config.RabbitMQConfig;
import com.dsmanioto.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

	private static final Logger logger = LoggerFactory.getLogger(RabbitMQSender.class);

	private AmqpTemplate amqpTemplate;
	private RabbitMQConfig rabbitMQConfig;

	@Autowired
	public RabbitMQSender(AmqpTemplate amqpTemplate, RabbitMQConfig rabbitMQConfig) {
		this.amqpTemplate = amqpTemplate;
		this.rabbitMQConfig = rabbitMQConfig;
	}

	public void send(Message message) {
		amqpTemplate.convertAndSend(rabbitMQConfig.getExchange(), rabbitMQConfig.getRoutingkey(), message);

		logger.info("Send msg {}", message);
	}

}
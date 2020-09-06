package com.dsmanioto.service;

import com.dsmanioto.model.Message;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

	private Logger logger = LogManager.getLogger(RabbitMQSender.class);

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${dsmanioto.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${dsmanioto.rabbitmq.routingkey}")
	private String routingkey;	

	public void send(Message message) {
		amqpTemplate.convertAndSend(exchange, routingkey, message);

		logger.info("Send msg = " + message);
	}

}
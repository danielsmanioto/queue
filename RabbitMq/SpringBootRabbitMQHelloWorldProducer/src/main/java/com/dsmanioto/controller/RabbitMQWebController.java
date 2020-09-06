package com.dsmanioto.controller;

import com.dsmanioto.model.Message;
import com.dsmanioto.service.RabbitMQSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@RestController
@RequestMapping(value = "/rabbit-mq")
public class RabbitMQWebController {

	private static final Logger logger = LoggerFactory.getLogger(RabbitMQWebController.class);

	@Autowired
	private RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("sender") String sender,
						   @RequestParam("message") String message) {

		rabbitMQSender.send(new Message(sender, message));

		return MessageFormat.format("Message {0} sent to the RabbitMQ JavaInUse Successfully", message);
	}

}


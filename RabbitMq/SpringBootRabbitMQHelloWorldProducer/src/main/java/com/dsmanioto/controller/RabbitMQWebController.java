package com.dsmanioto.controller;

import com.dsmanioto.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dsmanioto.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/rabbit-mq")
public class RabbitMQWebController {

	@Autowired
	private RabbitMQSender rabbitMQSender;

	@GetMapping(value = "/producer")
	public String producer(@RequestParam("sender") String sender,
						   @RequestParam("message") String message) {
		rabbitMQSender.send(new Message(sender, message));

		return "Message sent to the RabbitMQ JavaInUse Successfully";
	}

}


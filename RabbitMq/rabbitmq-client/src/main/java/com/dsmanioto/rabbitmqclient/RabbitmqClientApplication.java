package com.dsmanioto.rabbitmqclient;

import com.dsmanioto.rabbitmqclient.service.ReceiverService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
public class RabbitmqClientApplication {

	public static void main(String[] args) throws IOException, TimeoutException {
		SpringApplication.run(RabbitmqClientApplication.class, args);
	}

	@Bean
	public CommandLineRunner predefineValues(ReceiverService receiverService) {
		return (args) -> receiverService.receiver();
	}

}

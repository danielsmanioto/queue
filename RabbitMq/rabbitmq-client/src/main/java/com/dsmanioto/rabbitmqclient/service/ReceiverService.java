package com.dsmanioto.rabbitmqclient.service;

import com.dsmanioto.rabbitmqclient.RabbitmqClientApplication;
import com.dsmanioto.rabbitmqclient.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Service
public class ReceiverService {

    private static final Logger logger = LoggerFactory.getLogger(RabbitmqClientApplication.class);

    private RabbitMQConfig rabbitMQConfig;

    @Autowired
    public ReceiverService(RabbitMQConfig rabbitMQConfig) {
        this.rabbitMQConfig = rabbitMQConfig;
    }

    public void receiver() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(rabbitMQConfig.getHost());
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(rabbitMQConfig.getQueueName(), false, false, false, null);
        logger.info(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            logger.info(" [x] Received {}", message);
        };

        channel.basicConsume(rabbitMQConfig.getQueueName(), true, deliverCallback, consumerTag -> {});

        logger.debug(" [*] Queue executed as success.");
    }

}

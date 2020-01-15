package com.example.demo.mq.receive;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Map;


@Component
public class Producer {
    @Autowired
    RabbitTemplate rabbitTemplate;
    private final RabbitTemplate.ConfirmCallback confirmCallback=(correlationData,ack,cause)->{
        System.out.println("correlationData : " + correlationData);
        System.out.println("ack : " + ack);
        if (!ack) {
            System.err.println("ConfirmCallback发生异常....");
        }
    };
    private final RabbitTemplate.ReturnCallback returnCallback=(message, replyCode, replyText,
                                                                exchange, routingKey)->{
        System.out.println("message : " + message);
        System.out.println("replyCode : " + replyCode);
        System.out.println("replyText : " + replyText);
        System.out.println("exchange : " + exchange);
        System.out.println("routingKey : " + routingKey);
    };
    public void sendMsg(String message, Map<String, Object> properties) throws UnsupportedEncodingException {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setExpiration("5000");
        Message msg=new Message(message.getBytes("UTF-8"),messageProperties);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        rabbitTemplate.setReturnCallback(returnCallback);
        CorrelationData correlationData = new CorrelationData("123456789");
        rabbitTemplate.convertAndSend("exchange001", "springboot.test",msg, correlationData);
    }
}

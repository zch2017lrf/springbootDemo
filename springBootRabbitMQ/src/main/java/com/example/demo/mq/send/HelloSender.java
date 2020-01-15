package com.example.demo.mq.send;


import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {
    @Autowired
    private AmqpTemplate template;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final RabbitTemplate.ConfirmCallback confirmCallback=(correlationData, ack, cause)->{
        System.out.println("correlationData : " + correlationData);
        System.out.println("ack : " + ack);
        if (!ack) {
            System.err.println("ConfirmCallback发生异常....");
        }
    };

    @Async
    public void send(String i) {
        try {
            template.convertAndSend(null, "queue", "", new MessagePostProcessor() {
                @Override
                public Message postProcessMessage(Message message) throws AmqpException {
                    message.getMessageProperties().setExpiration(String.valueOf(100000));
                    return message;
                }
            });
        } catch (Exception e) {
            System.out.println("故障");
        }

    }
}
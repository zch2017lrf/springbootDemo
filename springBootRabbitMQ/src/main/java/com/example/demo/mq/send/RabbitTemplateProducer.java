package com.example.demo.mq.send;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * rabbitTemplate配置的ack
 */
@Component
public class RabbitTemplateProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    private final RabbitTemplate.ConfirmCallback confirmCallback=(correlationData,ack,cause)->{
        System.out.println("RabbitTemplateProducer-------correlationData : " + correlationData);
        System.out.println("RabbitTemplateProducer-------ack : " + ack);
        if (!ack) {
            System.err.println("RabbitTemplateProducer-------ConfirmCallback发生异常....");
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
        //关闭方法式的ack 自定义可以让多个生产者自定义错误处理
//        rabbitTemplate.setConfirmCallback(confirmCallback);
//        rabbitTemplate.setReturnCallback(returnCallback);
        CorrelationData correlationData = new CorrelationData("123456789");
        rabbitTemplate.convertAndSend("exchange001", "springboot.test",msg, correlationData);
    }
}

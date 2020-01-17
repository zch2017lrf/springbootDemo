package com.example.demo.mq.receive;

import com.example.demo.mq.send.RabbitTemplateProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {

    @Autowired
    RabbitTemplateProducer rabbitTemplateProducer;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void sendMsg() {
        try {
 //           rabbitTemplateProducer.sendMsg("123",new HashMap<>());
           rabbitTemplate.convertAndSend("exchange001", "springboot.test1","123456".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
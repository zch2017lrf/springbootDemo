package com.example.demo.mq.receive;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class HelloReceive {
    //    @RabbitListener(queues="queue")    //监听器监听指定的Queue
//    public void processC(String str) {
//        System.out.println("Receive:"+str);
//    }
    @RabbitListener(queues="queue")    //监听器监听指定的Queue
    public void process1(String user) {    //用User作为参数
        System.out.println("Receive1:"+user.toString());
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue001", durable = "true"),
            exchange = @Exchange(value = "exchange001", durable = "true",
                    type = "topic", ignoreDeclarationExceptions = "true"),
            key = "springboot.*",arguments = @Argument(name ="x-message-ttl",value = "10000")
    ))
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        //channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,true);
        System.out.println(new String(message.getBody()));
    }
}
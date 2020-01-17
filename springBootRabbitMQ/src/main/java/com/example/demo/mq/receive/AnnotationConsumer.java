package com.example.demo.mq.receive;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 基于注解的消费者
 */
@Component
public class AnnotationConsumer {

    @RabbitListener(queues = "queue")    //监听器监听指定的Queue
    public void process1(String user) {    //用User作为参数
        System.out.println("AnnotationConsumer-------:" + user.toString());
    }

    /**
     * 设置监听及过期时间
     *
     * @param message
     * @param channel exchange001  Queue=queue001  exchange=exchange001
     * @throws Exception
     */
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue001", durable = "true"),
            exchange = @Exchange(value = "exchange001", durable = "true",
                    type = "topic", ignoreDeclarationExceptions = "true"),
            key = "springboot.test1", arguments = @Argument(name = "x-message-ttl", value = "10000")
    ))
    @RabbitHandler
    public void onMessage(Message message, Channel channel) throws Exception {
        /**
         * 返回ack
         * false 不再循环返回失败消息
         */
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        System.out.println("queue001--------" + new String(message.getBody()));
    }
}
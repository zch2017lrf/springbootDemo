package com.example.demo.mq.receive;


import com.example.demo.config.TopicRabbitConfig;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 基于注解的消费者
 */
@Component
public class AnnotationConsumer {

    @RabbitListener(queues = "fanoutQueue")
    //监听器监听指定的Queue
    @RabbitHandler
    public void process1(Message message, Channel channel) throws Exception {
        /**
         * 返回ack
         * false 不再循环返回失败消息
         */
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        System.out.println("fanoutQueue-------:" +  new String(message.getBody()));
    }
    @RabbitListener(queues = "TestDirectQueue")
    //监听器监听指定的Queue
    @RabbitHandler
    public void direct(Message message, Channel channel) throws Exception {
        /**
         * 返回ack
         * false 不再循环返回失败消息
         */
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        System.out.println("TestDirectQueue-------:" + new String(message.getBody()));
    }

    /**
     * 设置监听及过期时间
     *
     * @param message
     * @param channel exchange001  Queue=queue001  exchange=exchange001
     * @throws Exception
     */
//    @RabbitListener(bindings = @QueueBinding(
//            value = @Queue(value = "topic.first", durable = "true"),
//            exchange = @Exchange(value = "topicExchange", durable = "true",
//                    type = "topic", ignoreDeclarationExceptions = "true"),
//            key = "topic.first", arguments = @Argument(name = "x-message-ttl", value = "10000")
//    ))
//    @RabbitHandler
//    public void onFirstMessage(Message message, Channel channel) throws Exception {
//        /**
//         * 返回ack
//         * false 不再循环返回失败消息
//         */
//        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//        System.out.println("topic.first--------" + new String(message.getBody()));
//    }
    /**
     * 设置监听及过期时间
     *
     * @param message
     * @param channel
     * @throws Exception
     */
    @RabbitListener(queues = TopicRabbitConfig.first)
    @RabbitHandler
    public void onFirstMessage(Message message, Channel channel) throws Exception {
        /**
         * 返回ack
         * false 不再循环返回失败消息
         */
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        System.out.println("kaleldo--------" + new String(message.getBody()));
    }

    @RabbitListener(queues = "topic.second")
    @RabbitHandler
    public void onSecondMessage(Message message, Channel channel) throws Exception {
        /**
         * 返回ack
         * false 不再循环返回失败消息
         */
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        System.out.println("topic.second--------" + new String(message.getBody()));
    }
}
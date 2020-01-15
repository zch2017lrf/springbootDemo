package com.example.demo.mq.receive;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeoutException;

public class MessageConsumer {

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        Channel channel  = connectionFactory.newConnection("RGP订单系统消息消费者").createChannel();

        // 声明队列 (队列名, 是否持久化, 是否排他, 是否自动删除, 队列属性);
        AMQP.Queue.DeclareOk declareOk = channel.queueDeclare("roberto.order.add", true, false, false, new HashMap<>());

        // 声明交换机 (交换机名, 交换机类型, 是否持久化, 是否自动删除, 是否是内部交换机, 交换机属性);
        channel.exchangeDeclare("roberto.order", BuiltinExchangeType.DIRECT, true, false, false, new HashMap<>());

        // 将队列Binding到交换机上 (队列名, 交换机名, Routing key, 绑定属性);
        channel.queueBind(declareOk.getQueue(), "roberto.order", "add", new HashMap<>());

        // 消费者订阅消息 监听如上声明的队列 (队列名, 是否自动应答(与消息可靠有关 后续会介绍), 消费者标签, 消费者)
        channel.basicConsume(declareOk.getQueue(), true, "RGP订单系统ADD处理逻辑消费者", new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(consumerTag);
                System.out.println(envelope.toString());
                System.out.println(properties.toString());
                System.out.println("消息内容:" + new String(body));
            }
        });
    }
}
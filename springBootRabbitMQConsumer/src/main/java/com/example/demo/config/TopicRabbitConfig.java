package com.example.demo.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 生产者 RabbitTemplate  基于java代码配置
 *
 */
@Configuration
public class TopicRabbitConfig {

    //绑定键
    public final static String first = "kaleldo";
    public final static String second = "topic.second";


    @Bean
    public Queue firstQueue() {
        return new Queue(TopicRabbitConfig.first);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(TopicRabbitConfig.second);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }

    //将firstQueue和topicExchange绑定,而且绑定的键值为topic.first
    //这样只要是消息携带的路由键是topic.first,才会分发到该队列
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(first);
    }

    //将secondQueue和topicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
    // 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(secondQueue()).to(exchange()).with(second);
    }

}

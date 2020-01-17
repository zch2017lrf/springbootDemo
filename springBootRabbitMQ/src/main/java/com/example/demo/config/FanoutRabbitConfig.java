package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutRabbitConfig {
    /**
     * fanout模式
     * @return
     */
    @Bean
    public Queue fanoutQueue() {
        return new Queue("fanoutQueue");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }
    @Bean
    Binding bindingExchangeA() {
        return BindingBuilder.bind(fanoutQueue()).to(fanoutExchange());
    }
}

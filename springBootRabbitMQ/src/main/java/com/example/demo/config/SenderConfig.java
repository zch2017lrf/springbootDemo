package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
@Configuration
public class SenderConfig {
    @Bean
    public Queue queue() {
        return new Queue("queue");
    }
}

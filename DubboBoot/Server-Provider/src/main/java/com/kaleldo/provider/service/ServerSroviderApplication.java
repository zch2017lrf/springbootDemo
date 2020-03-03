package com.kaleldo.provider.service;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableDubbo
@SpringBootApplication
public class ServerSroviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerSroviderApplication.class, args);
	}

}

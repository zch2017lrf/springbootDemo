package com.yxkj.aha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class AhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhaApplication.class, args);
	}
}

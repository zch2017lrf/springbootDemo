package com.example.demo.config;

import com.example.demo.entity.KaleldoClientsProperties;
import lombok.Data;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@SpringBootConfiguration
@PropertySource(value = {"classpath:test.properties"})
@ConfigurationProperties(prefix = "kaleldo.v1")
public class TestProperties {
    private KaleldoClientsProperties[] config = {};
}

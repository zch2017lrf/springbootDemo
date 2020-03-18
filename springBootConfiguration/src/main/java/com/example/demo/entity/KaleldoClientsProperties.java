package com.example.demo.entity;

import lombok.Data;

@Data
public class KaleldoClientsProperties {
    private String client;
    private String secret;
    private String grantType;
    private String scope;
}

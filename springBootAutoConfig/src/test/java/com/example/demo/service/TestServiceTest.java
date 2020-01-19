package com.example.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestServiceTest {
    @Autowired
    private TestService testService;
    @Autowired
    private String hello;

    @Test
    public void sayTest() {
        testService.sayTest();
        System.out.println(hello);
    }
}
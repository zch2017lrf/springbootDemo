package com.example.demo;

import com.example.demo.config.TestProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTest {

    @Autowired
    private TestProperties testProperties;

    @Test
    public void test(){
        System.out.println(testProperties.getConfig()[0]);
    }

}
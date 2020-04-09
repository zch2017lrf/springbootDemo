package com.example.demo;

import com.example.demo.service.UserService;
import com.example.demo.utils.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired
    private UserService userService;
    @Autowired
    private RedisService redisService;

    @Test
    public void get() {
        List<String> list = new ArrayList<>();
        list.add("tom");
        list.add("jon");
        list.add("alex");
//        redisService.lSet("username", list);
//        List getList =redisService.lGet("username", 0L, -1L);
//        System.out.println(getList);
//        redisService.hset("hello","item",list);
//        redisService.lSet("list", "tom");
//        redisService.lSet("list", "jon");
//        redisService.lSet("list", "alex");
        redisService.lUpdateIndex("list", 0L, "alex");
        redisService.lUpdateIndex("list", 1L, "tom");
        redisService.lUpdateIndex("list", 2L, "jon");


    }

}

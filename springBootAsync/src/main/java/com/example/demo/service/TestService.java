package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service
public class TestService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Async("kaleldoThreadPool")
//    public void asyncMethod() {
//        sleep();
//        logger.info("异步方法内部线程名称：{}", Thread.currentThread().getName());
//    }

    public void syncMethod() {
        sleep();
    }

    @Async("kaleldoThreadPool")
    public Future<String> asyncMethod() {
        sleep();
        logger.info("异步方法内部线程名称：{}", Thread.currentThread().getName());
        return new AsyncResult<>("hello async");
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

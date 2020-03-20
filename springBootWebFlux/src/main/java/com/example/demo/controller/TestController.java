package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@RestController
public class TestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 同步非阻塞
     * @return
     */
    @GetMapping("sync")
    public String sync() {
        Date sDate = new Date();
        String result = this.execute();
        System.out.println(new Date().getTime()-sDate.getTime());

        return result;
    }

    /**
     * execute方法返回一个值hello，所以可以使用Mono来处理返回值，
     * 使它成为一个异步方法。asyncMono方法返回Mono<String>类型，
     * 也就是一个String类型的数据发布者，
     * 我们不用去手动处理订阅关系，Spring会帮我们处理，我们直接返回即可
     * 异步非阻塞
     * @return
     */
    @GetMapping("async/mono")
    public Mono<String> asyncMono() {
        logger.info("async method start");
        Date sDate = new Date();
        Mono<String> result = Mono.fromSupplier(this::execute);
        logger.info("async method end");
        System.out.println(new Date().getTime()-sDate.getTime());
        return result;
    }

    private String execute() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }
    @GetMapping(value = "async/flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> asyncFlux() {
        logger.info("async method start");
        Flux<String> result = Flux.fromStream(IntStream.range(1, 5).mapToObj(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "int value：" + i;
        }));
        logger.info("async method end");
        return result;
    }
}

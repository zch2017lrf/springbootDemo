package com.kaleldo.provider.service.HelloService;

import com.alibaba.dubbo.config.annotation.Service;
import com.kaleldo.common.api.HelloService;
import org.springframework.stereotype.Component;


@Service(interfaceClass = HelloService.class)
@Component
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String message) {
        return "hello," + message;
    }
}

package com.example.demo.mapper;

import com.example.demo.entity.user;
import com.example.demo.service.userService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class userMapperTest {

    @Autowired
    private userService userService;

    @Test
    public void countByUsername() {
        user user = userService.queryUserById(1L);
//        System.out.println(userService.queryUserById(1L));
        System.out.println("用户名为" + user.getUsername() + "密码为" + user.getPassword());
//        user.setUsername("kaleldo");
//        userMapper.update(user);
        user user2=userService.queryUserById(1L);
        System.out.println("用户名为" + user2.getUsername() + "密码为" + user2.getPassword());
    }
}
package com.yxkj.aha.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: zch
 * @Date: 2018/12/6 08:42
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class userMapperTest {

    @Autowired
    userMapper userMapper;

    @Test
    public void selectOne() {
        System.out.println(userMapper.selectOne());
    }
}
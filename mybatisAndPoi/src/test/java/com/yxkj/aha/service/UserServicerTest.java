package com.yxkj.aha.service;

import com.yxkj.aha.dao.RoleDao;
import com.yxkj.aha.entity.user;
import com.yxkj.aha.mapper.userMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.*;

/**
 * @Auther: zch
 * @Date: 2018/12/20 11:02
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class UserServicerTest {

    @Autowired
    userMapper userMapper;

    @Autowired
    RoleDao roleDao;

    @Test
    public void findAll() {
        System.out.println(roleDao.findAll());


    }
}
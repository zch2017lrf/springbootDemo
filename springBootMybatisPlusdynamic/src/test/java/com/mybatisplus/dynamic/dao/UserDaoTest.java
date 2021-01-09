package com.mybatisplus.dynamic.dao;

import com.mybatisplus.dynamic.datasource.annotation.DataSource;
import com.mybatisplus.dynamic.entity.UserEntity;
import com.mybatisplus.dynamic.service.DynamicDataSourceTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private DynamicDataSourceTestService dynamicDataSourceTestService;

    @Test
    public void test() {
        UserEntity userEntity =dynamicDataSourceTestService.selectUser();
        System.out.println(userEntity.toString());
    }

}
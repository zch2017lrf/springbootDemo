package com.mybatisplus.dynamic.service;

import com.mybatisplus.dynamic.dao.UserDao;
import com.mybatisplus.dynamic.datasource.annotation.DataSource;
import com.mybatisplus.dynamic.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DynamicDataSourceTestService {

    @Autowired
    private UserDao userDao;

    @DataSource("slave2")
    public UserEntity selectUser() {
        return userDao.selectById(1);
    }

}

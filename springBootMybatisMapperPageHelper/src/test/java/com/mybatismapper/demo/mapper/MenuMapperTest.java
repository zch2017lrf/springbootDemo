package com.mybatismapper.demo.mapper;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatismapper.demo.entity.User;
import com.mybatismapper.demo.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuMapperTest {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private UserService userService;

    @Test
    public void hello(){
        System.out.println(userService.selectAll());
        PageHelper.startPage(2, 1);
        List<User> list = userService.selectAll();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        List<User> result = pageInfo.getList();
        System.out.println(result);
    }


}
package com.example.demo.mapper;

import com.example.demo.entity.RoleEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void test() {
//        System.out.println(userMapper.selectList(null ).get(0).getPassword());
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName("屠龙刀");
        roleEntity.setNote("你的屠龙刀是把伪劣品，而且你也是");
        roleEntity.setIsGirl(Boolean.TRUE);
        roleMapper.insert(roleEntity);
    }

}
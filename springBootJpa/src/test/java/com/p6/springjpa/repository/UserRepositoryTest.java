package com.p6.springjpa.repository;

import com.p6.springjpa.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test1() throws Exception {
        final User user = userRepository.save(new User("u1", "p1"));
        System.out.println("[添加成功] - [{}]"+user);
        final List<User> u1 = userRepository.findAllByUsername("u1");
        System.out.println("[条件查询] - [{}]"+u1);
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Sort.Order.desc("username")));
        final Page<User> users = userRepository.findAll(pageable);
        System.out.println("[分页+排序+查询所有] - [{}]"+users.getContent());
        userRepository.findById(users.getContent().get(0).getId()).ifPresent(user1 -> System.out.println("[主键查询] - [{}]"+user1));
        final User edit = userRepository.save(new User(user.getId(), "修改后的ui", "修改后的p1"));

        System.out.println("[修改成功] - [{}]"+edit);
        userRepository.deleteById(user.getId());
        System.out.println("[删除主键为 {} 成功] - [{}]"+user.getId());
    }
}
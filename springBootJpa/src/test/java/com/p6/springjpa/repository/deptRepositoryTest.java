package com.p6.springjpa.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class deptRepositoryTest {
    @Autowired
    areaRepository areaRepository;

    @Test
    public void findByDept_id() {
        System.out.println(areaRepository.findAll());
    }
}
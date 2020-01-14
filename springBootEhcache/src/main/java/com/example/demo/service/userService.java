package com.example.demo.service;

import com.example.demo.entity.user;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;


public interface userService {

    user update(@Param("user") user user);


    void deleteUserById(Long id);


    user queryUserById(Long id);
}

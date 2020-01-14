package com.example.demo.service.Impl;

import com.example.demo.entity.user;
import com.example.demo.mapper.userMapper;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "user")
@Service
public class userServiceImpl implements userService {
    @Autowired
    private userMapper userMapper;

    @CachePut(key = "#p0.id")
    @Override
    public user update(user user) {
        return userMapper.update(user);
    }

    @CacheEvict(key = "#p0",allEntries = true)
    @Override
    public void deleteUserById(Long id) {
    userMapper.deleteUserById(id);

    }

    @Cacheable(key = "#p0")
    @Override
    public user queryUserById(Long id) {
        return userMapper.queryUserById(id);
    }
}

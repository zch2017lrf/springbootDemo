package com.example.demo.mapper;

import com.example.demo.entity.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;


@Mapper
public interface userMapper {
    /**
     * 根据用户名统计（TODO 假设它是一个很复杂的SQL）
     *
     * @param username 用户名
     * @return 统计结果
     */
    int countByUsername(String username);

    List<user> queryUserByName(String username);


    user update(@Param("user") user user);


    void deleteUserById(Long id);


    user queryUserById(Long id);


}

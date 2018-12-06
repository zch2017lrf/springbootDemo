package com.yxkj.aha.mapper;

import com.yxkj.aha.entity.user;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: zch
 * @Date: 2018/12/6 08:37
 * @Description:
 */
@Component
@Mapper
public interface userMapper {

    @Select("select * from user")
    List<user> selectOne();

}

package com.yxkj.aha.dao;

import com.yxkj.aha.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * @Auther: zch
 * @Date: 2019/1/28 12:00
 * @Description:
 */
@Mapper
@Component
public interface RoleDao extends BaseMapper<Role> {
    List<Role> findAll();
}

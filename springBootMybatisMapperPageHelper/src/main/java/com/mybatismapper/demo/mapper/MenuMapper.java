package com.mybatismapper.demo.mapper;

import com.mybatismapper.demo.config.MyMapper;
import com.mybatismapper.demo.entity.Menu;
import com.mybatismapper.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface MenuMapper extends MyMapper<Menu> {
}

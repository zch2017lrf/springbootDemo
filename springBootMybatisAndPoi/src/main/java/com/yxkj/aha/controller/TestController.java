package com.yxkj.aha.controller;

import com.yxkj.aha.common.FileUtils;
import com.yxkj.aha.common.domain.ResponseBo;
import com.yxkj.aha.entity.user;
import com.yxkj.aha.mapper.userMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    userMapper userMapper;



    @RequestMapping("/index")
    @ResponseBody
    public List<user> test111() {
        return userMapper.selectOne();
    }

    @RequestMapping("/test/test")
    @ResponseBody
    public ResponseBo index() {

        List<user> list = userMapper.selectOne();
        return FileUtils.createExcelByPOIKit("班级表", list, user.class);
    }

    @RequestMapping("/test/csv")
    @ResponseBody
    public ResponseBo roleCsv() {
        List<user> list = userMapper.selectOne();
        return FileUtils.createCsv("班级表", list, user.class);
    }
}

package com.cors.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin
@Controller
public class TestController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }

}

package com.neo.controller;

import com.neo.config.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private RedisCache redisUtil;

    @RequestMapping("/hello")
    public String index() {
        System.out.println(redisUtil.hello());
        return "Hello World";
    }
}

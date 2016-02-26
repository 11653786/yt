package com.yt.controller;

import com.mybatis.entity.User;
import com.yt.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自定义返回异常
 * Created by yangtao on 15/11/16.
 */
@RestController
@RequestMapping(value = "/api/exception")
public class TestExceptionController {


    @Autowired
    Environment environment;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String main() throws MyException {
        if (1 == 1) {
            throw new MyException("ceshidaima!!!");
        }
        return "ok";
    }


    @RequestMapping(value = "/spring")
    @ResponseBody
    public User getSpring() {

        System.out.println(environment.getProperty("redis.maxIdle"));
        System.out.println(environment.getProperty("jdbc.driver"));
        User user = new User();
        user.setId(1);
        return user;
    }

}

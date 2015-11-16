package com.yt.controller;

import com.yt.entity.base.User;
import com.yt.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yangtao on 15/11/16.
 */
@RestController
@RequestMapping(value = "/api/exception")
public class TestExceptionController {

    @RequestMapping(value = "/test")
    @ResponseBody
    public String main() throws MyException {
        if (1 == 1) {
            throw new MyException("ceshidaima!!!");
        }
        return "ok";
    }

    @RequestMapping(value = "/test1")
    @ResponseBody
    public User aa() {
        User user = new User();
        user.setId(1);
        user.setUserName("HEHE");
        return user;
    }
}

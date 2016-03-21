package com.yt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 后台登录
 * Created by Administrator on 2016/2/29 0029.
 */
@Controller(value = "/login")
public class LoginController {


    /**
     * 提交登录页面
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String login() {
        return null;
    }

}

package com.yt.controller;

import com.yt.base.BaseAction;
import com.yt.entity.mybatis.User;
import com.yt.service.mybatis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 2015/8/11.
 */
@Controller
@RequestMapping(value = "/api/user")
public class UserAction extends BaseAction {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save")
    public String redis() {
        try {
            User user = userService.selectByPrimaryKey(1);
            System.out.println(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "index";
    }
}

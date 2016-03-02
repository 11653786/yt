package com.yt.controller;

import com.yt.base.BaseAction;
import com.yt.mybatis.AuthService;
import com.yt.mybatis.entity.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Administrator on 2016/3/1 0001.
 */
@Controller
@RequestMapping(value = "/api/auth")
public class AuthController extends BaseAction{

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "auth/list";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(Auth auth) {
        auth.setCreateDate(new Date());
        auth.setCreateUser(1);
        auth.setIsEnable("1");
        authService.insert(auth);
        return "auth/list";
    }
}

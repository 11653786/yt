package com.yt.controller;

import com.yt.base.BaseAction;
import com.yt.mybatis.AccountService;
import com.yt.mybatis.AuthService;
import com.yt.mybatis.entity.Auth;
import com.yt.mybatis.example.AuthExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by user on 2015/8/11.
 */
@Controller
@RequestMapping(value = "/api/account")
public class AccountAction extends BaseAction {

    @Autowired
    private AccountService accountService;
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/save")
    public void save() {
        try {
            AuthExample authExample=new AuthExample();
            authExample.createCriteria().andIdEqualTo(1);
            List<Auth> list=authService.selectByExample(authExample);
            System.out.println(list.size());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.yt.controller;

import com.yt.service.mybatis.entity.Account;
import com.yt.service.mybatis.AccountService;
import com.yt.base.BaseAction;
import com.yt.service.mybatis.entity.User;
import com.yt.service.mybatis.UserService;
import com.yt.util.Md5Utils;
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
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/save")
    public void redis() {
        try {
            User user = userService.selectByPrimaryKey(1);
            Account account=new Account();
            account.setUserName("admin");
            account.setMobile("15207183027");
            account.setIsLogin(1);
            account.setPassword(Md5Utils.getMD5String("123456"));
            System.out.println(user);
            accountService.insert(account);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

package com.yt.controller;

import com.yt.entity.Account;
import com.yt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yt.service.AccountService;
import com.yt.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2015/8/11.
 */
@Controller
@RequestMapping(value = "/api/user")
public class UserAction {



    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/index")
    public String index() {
        userService.init();
        Account account=new Account();
        //  account.setAccountId("1231");
        account.setAccountName("heheehe1");
        accountService.save(account);
        return "index";
    }

    @RequestMapping(value ="/directive")
    public String directive(){
        return "user/directive";
    }


    @RequestMapping(value ="/form",method= RequestMethod.GET)
    public String form(){
        return "user/form";
    }


    @RequestMapping(value ="/form",method= RequestMethod.POST)
    @ResponseBody
    public String formSub(String email,String username){
        User saveUser=new User();
        saveUser.setUserName(username);
 //       userService.save(saveUser);
        Account account=new Account();
      //  account.setAccountId("1231");
        account.setAccountName(email);
        accountService.save(account);
        return "ok";
    }

    @RequestMapping(value = "/save")
    public String saveSession(HttpSession session){
        session.setAttribute("hehe","hehe1");
        session.setMaxInactiveInterval(3600*3600);
        System.out.println(session.getAttribute("hehe"));
        return "index";
    }




    @RequestMapping(value="/rediss")
    public String redis(){
        User user=new User();
        user.setUserName("USERNAME1");
        userService.save(user);

       List<User> user1= userService.getPage();
        return "index";
    }


    @RequestMapping(value = "/datagrid")
    @ResponseBody
    public User datagrid(){
      User user=new User();
        user.setId(1);
        user.setUserName("hehe");
        return user;
    }

    @RequestMapping(value = "/str")
    @ResponseBody
    public String str(){
        return "str";
    }



}

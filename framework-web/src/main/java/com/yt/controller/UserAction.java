package com.yt.controller;

import com.yt.base.BaseAction;
import com.yt.entity.Account;
import com.yt.entity.User;
import com.yt.service.AccountService;
import com.yt.service.UserService;
import com.yt.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 2015/8/11.
 */
@Controller
@RequestMapping(value = "/api/user")
public class UserAction extends BaseAction{



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
        session.setMaxInactiveInterval(3600 * 3600);
        System.out.println(session.getAttribute("hehe"));
        return "index";
    }




    @RequestMapping(value="/rediss")
    public String redis(){
        User user=new User();
        user.setUserName("USERNAME1");
        userService.save(user);

        return "index";
    }


    @RequestMapping(value ="/list")
    public String list(){
        return "user/list";
    }


    @RequestMapping(value ="/datagrid")
    @ResponseBody
    public List<User> datagrid2(HttpServletRequest request){
        Map<String,Object> map=this.getParameters(request);
        Map<String,Object> map1=new HashMap<String, Object>();
        map1.put("page",1);
        map1.put("pageSize",15);
        List<User> list= userService.getPage(map);
        return list;
    }



}

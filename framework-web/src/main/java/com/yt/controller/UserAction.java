package com.yt.controller;

import com.yt.base.BaseAction;
import com.yt.dao.mongo.MongoDao;
import com.yt.entity.Account;
import com.yt.entity.User;
import com.yt.entity.mongodb.ModelMongo;
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
import java.util.*;

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

    @Autowired
    private MongoDao mongoDao;


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
        List<User> list= userService.getPage(map);
        return list;
    }

    @RequestMapping(value ="/users")
    @ResponseBody
    public User list(HttpServletRequest request){
       User user=new User();
        user.setId(1);
        user.setUserName("hehe");
        return user;
    }

    /**
     * mongodb连接成功!
     * @param request
     */
    @RequestMapping(value ="/mongotest")
    public void mongotest(HttpServletRequest request){
        mongoDao.test();
        ModelMongo modelMongo=new ModelMongo();
        Random random=new Random();
        modelMongo.setId(random.nextInt(1000));
        modelMongo.setAge(random.nextInt(1000));
        modelMongo.setName("mongodb测试111111"+random.nextInt(1000));
        modelMongo.setSex("女11"+random.nextInt(1000));
        mongoDao.save(modelMongo);
    }




}

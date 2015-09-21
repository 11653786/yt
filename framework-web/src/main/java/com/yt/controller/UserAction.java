package com.yt.controller;

import com.yt.base.BaseAction;
import com.yt.dao.mongo.dao.UserDaoMongo;
import com.yt.entity.base.Account;
import com.yt.entity.base.User;
import com.yt.entity.mongo.UserMongo;
import com.yt.service.AccountService;
import com.yt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @Autowired
    private UserDaoMongo userDaoMongo;

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
        session.setAttribute("hehe", "hehe1");
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
        userDaoMongo.test();
        UserMongo mongo=new UserMongo();
        mongo.set_id(userDaoMongo.getTotal(new Query()).intValue());
        mongo.setName("hehe");
        mongo.setAge("16岁");
        userDaoMongo.insertEntity(mongo);
    }


    @RequestMapping(value ="/getById")
    public void mongowhere(HttpServletRequest request){
        UserMongo userMongo=userDaoMongo.getById(0);
        System.out.println(userMongo.toString());
    }

    /**
     * mongo的updateFitst方法必须先查询出来再修改
     * @param request
     */
    @RequestMapping(value ="/update")
    public void saveAddress(HttpServletRequest request){
        Query query=new Query();
        Criteria criteria=new Criteria();
        criteria.where("_id").is(0);
        query.addCriteria(criteria);
        Update update=Update.update("name", "张三");
        userDaoMongo.update(query, update);
    }

    @RequestMapping(value ="/remove")
    public void getlimitList(HttpServletRequest request){
        UserMongo userMongo=userDaoMongo.getById(0);
        userDaoMongo.remove(userMongo, "rb_user");
    }


    @RequestMapping(value ="/saveOrUpdate")
    public void saveOrUpdate(HttpServletRequest request){
        UserMongo userMongo=userDaoMongo.getById(3);
        userMongo.setName("测试名称!");
        userDaoMongo.saveEntity(userMongo);
    }

    @RequestMapping(value ="/groupby")
    public void groupby(HttpServletRequest request){
        UserMongo userMongo=userDaoMongo.getById(3);
        userMongo.setName("测试名称!");
        userDaoMongo.saveEntity(userMongo);
    }





}

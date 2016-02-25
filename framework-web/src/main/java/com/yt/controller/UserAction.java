package com.yt.controller;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.yt.base.BaseAction;
import com.yt.entity.base.User;
import com.yt.entity.mongo.UserMongo;
import com.yt.service.mongo.template.user.UserServiceMongo;
import com.yt.service.mybatis.UserService;
import com.yt.util.mongoUtil.MongoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by user on 2015/8/11.
 */
@Controller
@RequestMapping(value = "/api/user")
public class UserAction extends BaseAction{



    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceMongo userServiceMongo;



    @RequestMapping(value ="/directive")
    public String directive(){
        return "user/directive";
    }


    @RequestMapping(value ="/form",method= RequestMethod.GET)
    public String form(){
        return "user/form";
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
        Random random=new Random();
        user.setUserName("hehe" + random.nextInt());
        return user;
    }

    /**
     * mongodb连接成功!
     * @param request
     */
    @RequestMapping(value ="/mongotest")
    public void mongotest(HttpServletRequest request){
        UserMongo mongo=new UserMongo();
        long total=userServiceMongo.getTotal();
        mongo.set_id(Integer.valueOf(String.valueOf(total)));
        Random random=new Random();
        mongo.setName("hehe"+random.nextInt(10));
        mongo.setAge("16岁");
        userServiceMongo.insert(mongo);
    }


    @RequestMapping(value ="/getById")
    public void mongowhere(HttpServletRequest request){
        UserMongo userMongo=userServiceMongo.getById(4);
        System.out.println(userMongo);
    }


    @RequestMapping(value ="/remove")
    public void getlimitList(HttpServletRequest request){
        UserMongo userMongo=userServiceMongo.getById(1);
        userServiceMongo.remove(0);
    }


    @RequestMapping(value ="/saveOrUpdate")
    public void saveOrUpdate(HttpServletRequest request){
        UserMongo userMongo=userServiceMongo.getById(3);
        userMongo.setName("测试名称!");
        userServiceMongo.saveOrUpdate(userMongo);
    }

    @RequestMapping(value ="/groupby")
    public void groupBy(HttpServletRequest request){
        userServiceMongo.groupBy("");
    }






    @RequestMapping(value ="/update")
    public void update(HttpServletRequest request){
        BasicDBObject where=new BasicDBObject();
        //全部改成15岁
        where.put("name","hehe");
        BasicDBObject set=new BasicDBObject(MongoUtils.$set,new BasicDBObject("age","12"));
        userServiceMongo.update(where, set);
    }

    @RequestMapping(value ="/getList")
    public void getList(HttpServletRequest request){
        BasicDBObject where=new BasicDBObject();
        userServiceMongo.getList(where);
        userServiceMongo.getList2();
    }

    @RequestMapping(value ="/getlist")
    public void getlist(HttpServletRequest request){
        BasicDBList where = new BasicDBList();

        //id大于4
        try{
            //id大于4
            where.add(new BasicDBObject("_id", new BasicDBObject(MongoUtils.$gt, 4)));
            //并且名字等于hehe4
            where.add(new BasicDBObject("name", new BasicDBObject(MongoUtils.$eq, "hehe4")));
            //mongo的or和and还有in写法是不一样的
            BasicDBObject or=new BasicDBObject();
            //or查询
            or.put(MongoUtils.$or,where);
            //and查询
            //查询id大于4,或者名称等于hehe4的
            List<UserMongo> LIST= userServiceMongo.getlist(or);
            System.out.println(LIST.size());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


    @RequestMapping(value ="/getlist1")
    public void getlist1(HttpServletRequest request){
        BasicDBList where = new BasicDBList();
        try{

            List<UserMongo> LIST= userServiceMongo.getlist(null);
            for(UserMongo u:LIST){
                System.out.println(u);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }






}

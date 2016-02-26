package com.yt.controller.rest;

import com.yt.base.BaseAction;
import com.mybatis.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangtao on 15/12/7.
 */
@RestController
@RequestMapping(value = "/nami")
public class AngularjsController extends BaseAction {


    @RequestMapping(value = "/datagrid", method = RequestMethod.POST)
    @ResponseBody
    public List<User> datagrid2(HttpServletRequest request) {
        return getUserList();
    }

    @RequestMapping(value = "/datagrid",method =RequestMethod.GET)
    @ResponseBody
    public List<User> datagrid(){
        return getUserList();
    }



    private List<User> getUserList() {
        List<User> users = new ArrayList<User>();
        for (int a = 0; a < 100; a++) {
            User user = new User(a, "name" + a);
            users.add(user);
        }
        return users;
    }

}

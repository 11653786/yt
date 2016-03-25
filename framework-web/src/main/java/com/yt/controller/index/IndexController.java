package com.yt.controller.index;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.yt.base.ResourceBaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * 登录和首页
 *
 * @author yangtao
 * @version 2.0, 2016年3月22日
 * @since com.dongrongonline 2.0
 */
@Controller
public class IndexController extends ResourceBaseController {



    @RequestMapping(value = {"", "/", "/index"})
    public ModelAndView index() {
        ModelAndView mv = null;
        if (mv == null) {
            mv = new ModelAndView("loginIn");
        } else {
            mv = new ModelAndView("index");
        }
        return mv;
    }


    /**
     * 后台登录
     *
     * @param loginName
     * @param password
     * @param session
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public void login(@RequestParam("loginName") String loginName, @RequestParam("password") String password, HttpSession session) throws IllegalAccessException, InvocationTargetException {

    }

    /**
     * 后台退出登录
     *
     * @return
     */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    @ResponseBody
    public void loginOut() {
    }

    @RequestMapping(value = "/editCurrentUserPwdPage")
    public ModelAndView editCurrentUserPwdPage() {
        ModelAndView mv = new ModelAndView("webpage/user/userEditPwd");
        return mv;
    }

    /**
     * 后台修改密码
     *
     * @param oldPwd
     * @param newPwd
     */
    @RequestMapping("/editCurrentUserPwd")
    @ResponseBody
    public void editCurrentUserPwd(
            @RequestParam("oldPwd") String oldPwd,
            @RequestParam("newPwd") String newPwd) {
    }
}

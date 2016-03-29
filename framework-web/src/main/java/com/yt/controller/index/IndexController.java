package com.yt.controller.index;

import com.yt.base.BaseAction;
import com.yt.model.BaseResult;
import com.yt.service.mybatis.EmployeeService;
import com.yt.shiro.ShiroUserPasswordToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;


/**
 * 登录和首页
 *
 * @author yangtao
 * @version 2.0, 2016年3月22日
 * @since com.dongrongonline 2.0
 */
@Controller
public class IndexController extends BaseAction {


    @Autowired
    private EmployeeService employeeService;


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
    public void login(@RequestParam("loginName") String loginName, @RequestParam("password") String password,
                      HttpSession session, @RequestParam(value = "isRememberMe", defaultValue = "false") boolean isRememberMe) {
        BaseResult baseResult = null;
            //判断用户名和密码是否输入正确
            baseResult = isLogin(loginName, password);
            if (!baseResult.isSuccess()) {

            } else {
                //
                Subject shiroLogin = SecurityUtils.getSubject();
                //参数名称,用户名，密码，是否记住密码，ip，登录方式，email，手机
                ShiroUserPasswordToken token = new ShiroUserPasswordToken(loginName, password, isRememberMe, null, "1", null, null);
                shiroLogin.login(token);
            }



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


    public BaseResult isLogin(String loginName, String password) {
        if (StringUtils.isEmpty(loginName)) {
            return BaseResult.fail("登录名称不能为空!");
        } else if (StringUtils.isEmpty(password)) {
            return BaseResult.fail("登录密码不能为空!");
        } else {
            return BaseResult.success("");
        }
    }
}

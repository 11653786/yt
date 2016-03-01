package com.yt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Member;

/**
 * Created by Administrator on 2016/3/1 0001.
 */
@Controller
@RequestMapping(value = "/api/frame")
public class FrameController {

    /**
     * 后台登录欢迎页
     *
     * @return
     */
    @RequestMapping(value = "welcome",method = RequestMethod.GET)
    public String index() {
        return "frame/welcome";
    }
}

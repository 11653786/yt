package com.yt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/3/1 0001.
 */
@Controller
@RequestMapping(value = "/api/auth")
public class AuthController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "auth/list";
    }

}

package com.yt.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2016/3/21 0021.
 */
@RequestMapping(value = "/api/auth")
@Controller
public class AuthController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "auth/list";
    }
}

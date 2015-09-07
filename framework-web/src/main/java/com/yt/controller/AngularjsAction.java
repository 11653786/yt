package com.yt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by user on 2015/8/26.
 */
@Controller
@RequestMapping(value = "/angularjs")
public class AngularjsAction {

    @RequestMapping(value = "/mvc")
    public String mvc() {
        return "angularjs/mvc";
    }

    @RequestMapping(value = "/module")
    public String module() {
        return "angularjs/module";
    }
}

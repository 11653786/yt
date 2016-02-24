package com.yt.controller.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试p文件和@value注解的使用
 * Created by Administrator on 2016/2/24 0024.
 */
@RestController
@RequestMapping(value = "/p")
public class PController {

    @Value("${jdbc.password}")
    private String mysqlPassword;

    @RequestMapping(value = "/values")
    @ResponseBody
    public String getValues(){
        return mysqlPassword;
    }
}

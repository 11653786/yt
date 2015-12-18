package com.yt.util;

import javax.servlet.http.HttpServletResponse;

/**
 * 跨域专用的工具类
 * Created by Administrator on 2015/12/18 0018.
 */
public class HttpUtils {

    //文档地址,jar包必须在项目里添加不能使用maven
    public final static String apiUrl = "http://www.bkjia.com/Javascript/977935.html";

    /**
     * 允许请求项
     */
    public final static String ACCESS_CONTROL_ALLOW_ORIGIN="Access-Control-Allow-Origin";
    /**
     * 允许的请求方法.get.post.update.delete.patch等
     */
    public final static String  ACCESS_CONTROL_AllOW_METHODS="Access-Control-Allow-Methods";

    /**
     * 允许的请求头
     */
    public final static String ACCESS_CONTROL_AllOW_HEADERS="Access-Control-Allow-Headers";
    /**
     * 设置请求头用来搞定跨域的问题
     *
     * @param response
     */
    public static void setHeader(HttpServletResponse response) {
        response.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN, "*");
        response.setHeader(ACCESS_CONTROL_AllOW_METHODS, "*");
        response.setHeader(ACCESS_CONTROL_AllOW_HEADERS,"x-requested-width,content-type");
    }
}

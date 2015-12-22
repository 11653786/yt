package com.yt.filter;

import com.thetransactioncompany.cors.CORSFilter;
import com.yt.util.HttpUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by yangtao on 15/12/9.
 */
public class MyFilter extends CORSFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpUtils.setHeader(response);
        Enumeration enumeration= request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String key=enumeration.nextElement().toString();
            System.out.println(key+","+request.getHeader(key));
        }
        filterChain.doFilter(request, response);


    }

    public void destroy() {

    }


}

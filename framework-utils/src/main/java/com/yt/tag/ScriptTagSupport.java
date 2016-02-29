package com.yt.tag;

import com.yt.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/2/29 0029.
 */
public class ScriptTagSupport extends TagSupport {

    private boolean hasJquery;

    private boolean hasAngularjs;

    private boolean hasZtree;

    private boolean hasEasyUi;

    private boolean hasBootStrap;

    String jsPath = "/resource/js/";

    String cssPath = "/resource/css/";

    @Override
    public int doStartTag() throws JspException {
        try {
            super.pageContext.getOut().write(getIncludeFile().toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.doStartTag();
    }

    /**
     * 拼装标签的方法
     *
     * @return
     */
    private StringWriter getIncludeFile() {
        StringWriter sw = new StringWriter();

        if (validJquery()) {
            sw.append("<script type='text/javascript' src=" + getWebPath() + jsPath + "jquery/jquery.js></script>");
        }

        if (StringUtils.checkNotNull(hasAngularjs) && hasAngularjs) {
            sw.append("<script type='text/javascript' src=" + getWebPath() + jsPath + "angularjs/angular.js></script>");
        }

        if (StringUtils.checkNotNull(hasZtree) && hasZtree) {
            sw.append("<script type='text/javascript' src=" + getWebPath() + jsPath + "ztree/jquery.ztree.all.js></script>");
            sw.append("<link rel='stylesheet' href=" + getWebPath() + cssPath + "zTreeStyle/zTreeStyle.css></link>");
        }
        if (StringUtils.checkNotNull(hasEasyUi) && hasEasyUi) {
            sw.append("<script type='text/javascript' src=" + getWebPath() + jsPath + "easyui/jquery.easyui.min.js></script>");
            sw.append("<link rel='stylesheet' href=" + getWebPath() + cssPath + "themes/icon.css></link>");
            sw.append("<link rel='stylesheet' href=" + getWebPath() + cssPath + "themes/default/easyui.css></link>");
        }
        if (StringUtils.checkNotNull(hasBootStrap) && hasBootStrap) {
            sw.append("<link rel='stylesheet' href=" + getWebPath() + cssPath + "bootstrap/css/bootstrap.css></link>");
        }
        return sw;
    }


    private String getWebPath() {
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        return request.getContextPath();
    }

    /**
     * 判断是否引入jquery
     *
     * @return
     */
    private boolean validJquery() {
        return hasJquery = StringUtils.checkNotNull(hasJquery) ? true : false;
    }

    public boolean isHasJquery() {
        return hasJquery;
    }

    public void setHasJquery(boolean hasJquery) {
        this.hasJquery = hasJquery;
    }

    public boolean isHasAngularjs() {
        return hasAngularjs;
    }

    public void setHasAngularjs(boolean hasAngularjs) {
        this.hasAngularjs = hasAngularjs;
    }

    public boolean isHasZtree() {
        return hasZtree;
    }

    public void setHasZtree(boolean hasZtree) {
        this.hasZtree = hasZtree;
    }

    public boolean isHasEasyUi() {
        return hasEasyUi;
    }

    public void setHasEasyUi(boolean hasEasyUi) {
        this.hasEasyUi = hasEasyUi;
    }

    public boolean isHasBootStrap() {
        return hasBootStrap;
    }

    public void setHasBootStrap(boolean hasBootStrap) {
        this.hasBootStrap = hasBootStrap;
    }

}

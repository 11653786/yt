package com.yt.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Administrator on 2016/2/29 0029.
 */
public class ScriptTagSupport extends SimpleTagSupport {
    private String counts;

    public String getCount() {
        return counts;
    }

    public void setCount(String count) {
        this.counts = count;
    }

    @Override
    public void doTag() throws JspException, IOException {
        // TODO Auto-generated method stub
        JspWriter out = this.getJspContext().getOut();
        String str = invokeBody();
        out.println(str.toUpperCase());
    }

    /**
     * 拼装标签的方法
     * @return
     */
    private String invokeBody() {
        // TODO Auto-generated method stub
        JspFragment body = this.getJspBody();
        StringWriter sw = new StringWriter();
        sw.append("hello,world");
        if (body != null) {
            try {
                body.invoke(sw);
            } catch (JspException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return sw.toString();
    }
}

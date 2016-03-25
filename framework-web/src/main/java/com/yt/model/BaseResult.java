package com.yt.model;

/**
 * Created by Administrator on 2016/3/24 0024.
 */

import com.yt.util.yt.annotation.RestAttribute;

import java.io.Serializable;


public class BaseResult implements Serializable {

    private static final long serialVersionUID = 1768125542229706041L;

    public BaseResult() {

    }

    public BaseResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    public BaseResult(String msg) {
        this.msg = msg;
    }

    public BaseResult(boolean success) {
        this.success = success;
    }

    @RestAttribute(name = "提示成功消息", remark = "提示成功消息")
    protected boolean success;
    @RestAttribute(name = "娑堟伅淇℃伅", remark = "娑堟伅淇℃伅锛屼竴鑸儏鍐典笅鍙湁鍑虹幇閿欒鎵嶄細鏈夐敊璇憖淇℃伅锛屽鏋滄垚鍔熻鍊间负绌�", notnull = false)
    protected String msg;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}


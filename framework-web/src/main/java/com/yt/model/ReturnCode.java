package com.yt.model;

/**
 * Created by yangtao on 15/11/17.
 */
public class ReturnCode {

    private Integer code;

    private String reason;

    private String message;


    public ReturnCode(Integer code, String reason, String message) {
        this.code = code;
        this.message = message;
        this.reason = reason;
    }
}

package com.yt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by yangtao on 15/11/16.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "reason!!!!")
public class MyException extends Exception {

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}

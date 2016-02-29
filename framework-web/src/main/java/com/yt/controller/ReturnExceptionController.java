package com.yt.controller;

import com.yt.model.ReturnCode;
import com.yt.util.JsonUtil;
import com.yt.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

/**
 * component 相当于 component-scan
 * 每一个controller都要调用这个处理异常的类就必须,@ControllerAdvice
 * Created by yangtao on 15/11/16.
 */
@Component
@ControllerAdvice
public class ReturnExceptionController {


    Logger logger = LoggerFactory.getLogger(ReturnExceptionController.class);

    /**
     * 所有的异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public ReturnCode returnException(RuntimeException e) {

        return null;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public String returnRuntimeException(Exception exception) {
        //判断异常类是否使用了responseStatus这个注解
        ResponseStatus status = exception.getClass().getAnnotation(ResponseStatus.class);
        ReturnCode errorcode = null;
        try {
            if (StringUtils.checkNotNull(status)) {
                Integer code = status.value().value();
                String reason = status.reason();
                String message = exception.getMessage();
                errorcode = new ReturnCode(code, reason, message);
            }
        } catch (Exception e) {
            logger.error("500错误", e.getMessage());
        }
        return JsonUtil.toJson(errorcode);
    }

    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    public String returnIoException() {
        return "ioexception";
    }
}

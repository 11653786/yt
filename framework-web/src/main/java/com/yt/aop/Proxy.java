package com.yt.aop;

import com.yt.service.mybatis.entity.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by user on 2015/9/6.
 */
@Aspect
@Component
public class Proxy {
    /**
     * 要监控的方法
     */
    @Pointcut("execution(public * com.core.mybatis.base.BaseDao.insert(..))")
    private void saveMethod() {
    }

    /**
     * aop做日志
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("saveMethod()")
    public Object aroundPointcut(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object[] objects = pjp.getArgs();
        for (Object object : objects) {
            if (object instanceof Account) {
                Account account= (Account) object;
            }
        }

        //获取监控方法得到的返回值
        Object result = pjp.proceed();
        if (result.equals(1)) {
            //保存日志
        }
        long end = System.currentTimeMillis();
        //耗时
        long totalTime=end-start;
        return result;
    }
}



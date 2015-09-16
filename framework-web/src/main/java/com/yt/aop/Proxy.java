package com.yt.aop;

import com.yt.entity.Account;
import com.yt.service.UserService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * Created by user on 2015/9/6.
 */
@Aspect
@Component
public class Proxy {


    @Autowired
    private UserService userService;


    @Pointcut("execution(public * com.yt.dao.base.BaseDao.save(..))")
    private void saveMethod(){}//定义一个切入点


    /**
     * 用作aop日志
     * @param point
     * @throws Throwable
     */
    @Around("saveMethod()")
    public void doBasicProfiling(JoinPoint point) throws Throwable{
        System.out.println("in");

        Object[] args=point.getArgs();
        System.out.println( "getTarget:"+ point.getTarget());
        System.out.println("url+method:" + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        for (int i = 0; i < args.length; i++) {
          Object obj= args[i]; //输出传入的参数
            //判断当前obj类型是不是account类型
            System.out.println("obj:"+obj);
            if(obj instanceof Account){
                    System.out.println(Account.class.getName());
                    Account account= (Account) obj;
                System.out.println(account);
            }
        }
        System.out.println("out");
    }


}

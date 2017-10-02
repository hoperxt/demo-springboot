package com.example.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class HttpAspect {

    //设置一个切点
    @Pointcut("execution(public * com.example.controller.BookController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(){
        System.out.println("before");
    }

    @After("log()")
    public void doAfter(){
        System.out.println("after");
    }
}

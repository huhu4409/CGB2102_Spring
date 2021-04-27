package com.jt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class SpringAOP {
    @Pointcut("@annotation(com.jt.anno.Cache)")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("获得连接点的类型："+joinPoint.getTarget().getClass());
        System.out.println("获得连接点的类名：" + joinPoint.getSignature().getDeclaringType());
        System.out.println("获得连接点的方法名：" + joinPoint.getSignature().getName());
        System.out.println("获得连接点的方法参数：" + Arrays.toString(joinPoint.getArgs()));
    }
}

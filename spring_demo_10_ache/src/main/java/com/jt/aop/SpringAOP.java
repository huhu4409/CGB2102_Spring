package com.jt.aop;

import com.jt.pojo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class SpringAOP {

    private static Map<Integer, User> map = new HashMap<Integer, User>();

    /**
     * 需求：用户第一次查询走目标方法
     *      用户第二次查询走缓存 不执行目标方法
     * 判断依据：如何判断用户是否为第一次查询？
     *      通过map集合进行判断 有数据证明不是第一次查询
     * 执行步骤：1.获取用户查询的参数
     *          2.判断map集合中是否有该数据
     *          true：从map集合中get之后返回
     *          false：执行目标方法，之后将*/

    //切入点表达式：拦截service包中的所有方法
    @Around("execution(* com.jt.service..*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        //1.获取目标对象的参数
        Object[] args = joinPoint.getArgs();
        //2.强制类型转换为对象
        User user = (User) args[0];
        int id = user.getId();
        //3.判断map集合中是否含有该数据，user的id是唯一标识
        if (map.containsKey(id)){
            System.out.println("aop执行缓存方法");
            return map.get(id);
        } else {
            try {
                //map中没有数据 执行目标方法
                proceed = joinPoint.proceed();
                map.put(id, user);
                System.out.println("aop执行目标方法");
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return  proceed;
    }
}

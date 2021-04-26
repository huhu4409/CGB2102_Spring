package com.jt.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component  //1.AOP需要被Spring容器管理
@Aspect     //2.标识该类为AOP切面 Spring容器默认不能识别切面注解,需要手动配置
public class SpringAOP {




    /**
     * 切入点表达式练习
     * 1.within(com.jt.*.DeptServiceImpl)   一级包下的类
     * 2.within(com.jt..*.DeptServiceImpl) ..代表多级
     * 3.within(com.jt..*)                 包下的所有的类
     *
     * execution(返回值类型 包名.类名.方法名(参数列表))
     * 1.execution(* com.jt..*.DeptService.add*())
     * 注释：返回值类型任意的，com.jt下的所有包中的DeptServiceImpl类的add开头的方法，并且没有参数
     *
     * 2.execution(* com.jt..*.*(..))
     * 注释：返回值类型任意，com.jt包下的所有包的所有类的所有方法 任意参数
     *
     * 3.execution(* com.jt..*.*(int))
     * execution(* com.jt..*.*(Integer))
     * 强调：Spring表达式中没有自动拆装箱功能！注意参数类型
     * */

    /*@Before("bean(deptServiceImpl)")*/
    /*@Before("within(com.jt..* )")*/
    /*@Before("execution(* com.jt..*.*(..))")*/
    /*@Before("@annotation(com.jt.anno.Cache)")*/
    //定义切入点表达式
    @Pointcut("@annotation(com.jt.anno.Cache)")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(JoinPoint joinPoint){
        System.out.println("获取目标对象的类型：" + joinPoint.getTarget().getClass());
        System.out.println("获取目标对象的类名：" + joinPoint.getSignature().getDeclaringTypeName());
        System.out.println("获取目标对象的方法名：" + joinPoint.getSignature().getName());
        System.out.println("获取方法参数：" + Arrays.toString(joinPoint.getArgs()));
        System.out.println("我是before通知");
    }
    @AfterReturning(value = "pointcut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint,Object result){
        System.out.println("我是afterReturning通知");
        System.out.println("用户的返回值结果:" + result);
    }
    @AfterThrowing(value = "pointcut()",throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("获取异常信息:" + e.getMessage());
        System.out.println("获取异常类型:" + e.getClass());
        System.out.println("我是afterThrowing通知");
    }
    @After("pointcut()")
    public void after(){
        System.out.println("我是after通知");
    }

    /**关于环绕通知的说明
     * 作用：可以控制目标方法是否执行
     * 参数：ProceedingJoinPoint 通过proceed方法*/

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint){
        Object proceed = null;
        System.out.println("环绕通知开始");
        //1.执行下一个通知 2.执行目标方法 3.接收返回值
        try {
            long start = System.currentTimeMillis();
            proceed = joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("耗时：" + (end - start) + "ms");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕通知结束");
        System.out.println("我是around通知");
        return proceed;
    }
}

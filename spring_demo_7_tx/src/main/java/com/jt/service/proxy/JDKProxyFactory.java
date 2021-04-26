package com.jt.service.proxy;

import java.awt.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//利用一个工厂动态为目标对象创建代理
public class JDKProxyFactory {

    public static Object getProxy(final Object target){
        /*
        * 1.ClassLoader classLoader 类加载器（获取目标对象的class）
        * 2.类<?>[] interfaces,JDK代理要求 必须有接口，Java中可以多实现
        * 3.InvocationHandler h 对目标方法进行扩展
        * */
        //1.获取类加载器
        ClassLoader classLoader = target.getClass().getClassLoader();
        //2.获取接口数组
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //3.通过动态代理创建对象
        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
            //invoke方法：代理对象调用方法时invoke执行，扩展方法的编辑位置
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    //添加事务的控制
                    System.out.println("事务开始");
                    long start = System.currentTimeMillis();
                    //执行目标方法
                    //target真实的目标对象，method方法对象，args方法参数
                    result = method.invoke(target, args);
                    long end = System.currentTimeMillis();
                    System.out.println("方法执行时间为：" + (end - start) + "ms");
                    System.out.println("事务结束");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("事务回滚");
                }
                return result;
            }
        });
        return proxy;
    }
}

package com.jt.test;

import com.jt.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

public class TestFactory {
    @Test
    public void testCalendar(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar1 = (Calendar) context.getBean("calendar1");
        System.out.println("当前时间为：" + calendar1.getTime());
    }

    @Test
    public void testCalendar1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar2 = (Calendar) context.getBean("calendar2");
        System.out.println("当前时间为：" + calendar2.getTime());
    }

    @Test
    public void testSpringFactory(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Calendar calendar3 = (Calendar) context.getBean("calendar3");
        System.out.println("当前时间为：" + calendar3.getTime());
    }

    @Test
    public void testUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.getBean("user");
        context.getBean("user");
        context.getBean("user");
        context.getBean("user");
    }

    @Test
    public void testLife(){
        //1.容器创建
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //2.获取对象
        User user = (User) context.getBean("user");
        //3.调用方法
        user.say();
        //4.关闭容器，销毁对象
        context.close();
    }
}

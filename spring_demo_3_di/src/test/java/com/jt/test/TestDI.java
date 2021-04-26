package com.jt.test;

import com.jt.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDI {
    @Test
    public void testUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        System.out.println((User)context.getBean("user"));
    }
}

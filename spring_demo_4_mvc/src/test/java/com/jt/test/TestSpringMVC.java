package com.jt.test;

import com.jt.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMVC {
    @Test
    public void testAdd(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserController controller = (UserController) context.getBean("userController");
        controller.addUser();
    }
}

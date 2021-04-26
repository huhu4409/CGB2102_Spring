package com.jt.test;

import com.jt.config.SpringConfig;
import com.jt.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringMVC {
    @Test
    public void testAddUser(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application_1.xml");
        //UserController controller = (UserController)context.getBean(UserController.class);
        UserController controller = (UserController)context.getBean("userController");
        controller.addUser();
    }

    @Test
    public void testAnno(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller = (UserController) context.getBean("userController");
        controller.addUser();
    }
}

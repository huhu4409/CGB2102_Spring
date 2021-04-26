package com.jt.test;

import com.jt.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {
    @Test
    public void testAnno(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application_annotation.xml");
        UserController controller = (UserController) context.getBean("userController");
        controller.addUser();
    }

}

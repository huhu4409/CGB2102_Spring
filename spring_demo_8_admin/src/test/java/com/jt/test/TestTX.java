package com.jt.test;

import com.jt.config.SpringConfig;
import com.jt.controller.UserController;
import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.service.proxy.DynamicProxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestTX {
    @Test
    public void testMethod(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller = (UserController) context.getBean("userController");
        UserService target = (UserService) context.getBean("target");
        UserService proxy = (UserService) DynamicProxy.getProxy(target);
        controller.addUser(proxy);
    }
}

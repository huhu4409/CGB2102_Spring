package com.jt.test;

import com.jt.config.SpringConfig;
import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.service.proxy.JDKProxyFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {

    @Test
    public void testTx(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //使用接口拿到对象，必须保证接口只有一个实现类
        //UserService service = (UserService)context.getBean(UserService.class);
        UserService service = (UserService)context.getBean("userServiceImpl");
        User user = new User();
        user.setId(10023);
        user.setUsername("修改室");
        service.addUser(user);
    }

    @Test
    public void testStaticProxy(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService service = (UserService)context.getBean("userService");
        User user = new User();
        user.setId(123456);
        user.setUsername("奇葩了这么");
        service.addUser(user);
    }

    //测试JDK动态代理
    @Test
    public void testJDKProxy(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //1.获取用户目标对象
        UserService target = (UserService) context.getBean("target");
        //2.获取代理对象
        UserService userService = (UserService) JDKProxyFactory.getProxy(target);
        //3.打印代理对象的类型
        System.out.println(userService.getClass());
        User user = new User();
        user.setId(14789);
        user.setUsername("怎么么");
        userService.addUser(user);
    }
}

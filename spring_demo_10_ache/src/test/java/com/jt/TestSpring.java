package com.jt;

import com.jt.config.SpringConfig;
import com.jt.pojo.User;
import com.jt.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService service = context.getBean(UserService.class);
        User user = new User();
        user.setId(120);
        user.setUsername("年后");
        service.findUser(user);
    }
}

package com.jt.config;

import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.jt")
@PropertySource(value = "classpath:/user.properties",encoding = "utf-8")
public class SpringConfig {

    @Value("${user.username}")
    private String username;
    @Value("${user.gender}")
    private String gender;
    @Bean
    public User getUser(){
        User user = new User();
        user.setUsername(username);
        user.setGender(gender);
        return user;
    }
}

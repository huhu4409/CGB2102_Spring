package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    /*
    * @autowired:首先根据属性的类型进行注入  如果类型不能匹配，则根据属性的名称进行注入
    * 如果添加了@Qualifier("userServiceB") 则根据属性名称注入  若名称错误，则报错返回
    * */
    @Autowired
    @Qualifier("userServiceB")
    private UserService userService;
    @Autowired
    private User user;

    public void addUser(){
        userService.addUser(user);
    }
}

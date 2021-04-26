package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private User user;
    @Autowired
    private UserService service;

    /*public void setUser(User user) {
        this.user = user;
    }

    public void setService(UserService service) {
        this.service = service;
    }*/

    public void addUser(){
        service.addUser(user);
    }
}

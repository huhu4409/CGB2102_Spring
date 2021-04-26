package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;

public class UserController {
    private User user;
    private UserService service;

    public void setUser(User user) {
        this.user = user;
    }

    public void setService(UserService service) {
        this.service = service;
    }

    public void addUser(){
        service.addUser(user);
    }
}

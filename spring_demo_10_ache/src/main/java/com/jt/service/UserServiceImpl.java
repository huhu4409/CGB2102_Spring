package com.jt.service;

import com.jt.pojo.User;

public class UserServiceImpl implements UserService{
    @Override
    public void findUser(User user) {
        System.out.println("找人");
    }
}

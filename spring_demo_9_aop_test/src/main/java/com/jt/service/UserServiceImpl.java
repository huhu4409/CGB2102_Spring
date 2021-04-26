package com.jt.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public void addUser() {
        System.out.println("增加一个为新用户");
    }

    @Override
    public void updateUser() {
        System.out.println("更新一位小朋友的信息");
    }

    @Override
    public String delUser() {
        return "随机删除一位幸运观众";
    }
}

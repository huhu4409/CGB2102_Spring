package com.jt.service;

import com.jt.anno.Cache;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Override
    @Cache
    public void addUser() {
        System.out.println("增加一个新用户");
    }

    @Override
    @Cache
    public void updateUser() {
        System.out.println("更新一位小朋友的信息");
    }

    @Override
    @Cache
    public String delUser() {
        return "随机删除一位幸运观众";
    }
}

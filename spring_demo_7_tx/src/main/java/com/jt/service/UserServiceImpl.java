package com.jt.service;

import com.jt.dao.UserMapper;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("target")//代理目标
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void delUser(User user) {
        userMapper.delUser(user);
    }
//    @Override
//    public void addUser(User user) {
//        try {
//            System.out.println("事务开始！！！");
//            userMapper.addUser(user);
//            System.out.println("事务结束！！！");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}

package com.jt.service.proxy;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class StaticProxy implements UserService {

    //引入目标对象
    @Autowired
    private UserService target;
    //目的：对原有方法进行扩展
    @Override
    public void addUser(User user) {
        try {
            System.out.println("事务开始");
            target.addUser(user);
            System.out.println("事务结束");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("事务回滚");
        }
    }

    @Override
    public void delUser(User user) {
        System.out.println("删除用户");
    }
}

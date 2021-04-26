package com.jt.dao;

import com.jt.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Override
    public void addUser(User user) {
        System.out.println("添加一位小用户：" + user);
    }
}

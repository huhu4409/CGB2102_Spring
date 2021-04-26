package com.jt.service;

import com.jt.dao.UserDao;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("target")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void addUser(User user) {
        String name = user.getUsername() + "一直心向光明";
        user.setUsername(name);
        userDao.addUser(user);
    }

    @Override
    public void delUser(User user) {
        userDao.delUser(user);
    }
}

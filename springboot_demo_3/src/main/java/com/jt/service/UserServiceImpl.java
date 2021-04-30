package com.jt.service;

import com.jt.dao.UserDao;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.insert(user);
    }
}

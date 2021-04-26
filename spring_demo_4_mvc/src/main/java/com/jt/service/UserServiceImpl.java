package com.jt.service;

import com.jt.dao.UserDao;
import com.jt.pojo.User;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        String name = user.getName()+"小可爱";
        user.setName(name);
        userDao.addUser(user);
    }
}

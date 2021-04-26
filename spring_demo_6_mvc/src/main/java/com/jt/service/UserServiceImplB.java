package com.jt.service;

import com.jt.dao.UserDao;
import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceB")
public class UserServiceImplB implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public void addUser(User user) {
        String name = user.getUsername()+"超级厉害";
        user.setUsername(name);
        userDao.addUser(user);
    }
}

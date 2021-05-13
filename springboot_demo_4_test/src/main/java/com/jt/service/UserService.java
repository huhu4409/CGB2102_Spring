package com.jt.service;

import com.jt.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAllUser();
    void updateUser(User user);
    void delUser(User user);
}

package com.jt.dao;

import com.jt.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapperImpl implements UserMapper{
    @Override
    public void addUser(User user) {
        System.out.println("用户入库：" + user);
    }

    @Override
    public void delUser(User user) {
        System.out.println("删除用户：" + user);
    }
}

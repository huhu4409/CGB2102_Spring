package com.jt.service;

import com.jt.anno.Cache;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService{

    @Override
    @Cache
    public void addDept() {
        System.out.println("添加部门信息");
    }

    @Override
    @Cache  //被注解标识
    public void updateDept() {
        System.out.println("更新部门信息");
    }

    @Override
    @Cache
    public String after(Integer id) {
        return "返回值";
    }

    @Override
    @Cache
    public void afterThrow() throws Exception {
        throw new Exception();
    }

    @Override
    @Cache
    public void doAround() {
        System.out.println("我曾一个人在酒吧疯狂的玩耍");
    }
}

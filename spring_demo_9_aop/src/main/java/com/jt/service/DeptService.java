package com.jt.service;

public interface DeptService {
    void addDept();
    void updateDept();
    //AOP中测试返回值
    String after(Integer id);
    //测试异常通知
    void afterThrow() throws Exception;
    //测试环绕通知
    void doAround();
}

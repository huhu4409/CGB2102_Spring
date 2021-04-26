package com.jt.pojo;

public class User {
    public String conn;

    //1.创建对象
    public User(){
        System.out.println("创建一个用户");
    }
    //2.初始化对象
    public void init(){
        this.conn = "赋值数据库连接";
        System.out.println(this.conn);
    }

    //3.用户调用的方法
    public void say(){
        System.out.println("你好，哥们");
    }

    //4.销毁对象
    public void destroy(){
        this.conn = null;
        System.out.println("释放资源" + this.conn + "...........");
    }
}

package com.jt.test;

import com.jt.config.SpringConfig;
import com.jt.service.DeptService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    @Test
    public void test01(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        DeptService deptService = context.getBean(DeptService.class);
        System.out.println(deptService.getClass());//代理对象
        deptService.addDept();
//        deptService.updateDept();
//        deptService.after(12);
    }
//    @Test
//    public void test02(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        DeptService deptService = context.getBean(DeptService.class);
//        System.out.println(deptService.getClass());//代理对象
//        deptService.after(12);
//    }
//    @Test
//    //自定义异常抛出
//    public void test03() throws Exception {
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        DeptService deptService = context.getBean(DeptService.class);
//        deptService.afterThrow();
//    }
//
//    @Test
//    public void test04(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        DeptService deptService = context.getBean(DeptService.class);
//        deptService.doAround();
//    }
}

package com.jt;

import com.jt.pojo.Dept;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest //在执行测试方法时自动的启动Spring容器
class SpringbootDemo1ApplicationTests {
    //当容器启动成功之后，SpringBoot负责将对象进行注入
    @Autowired
    private Dept dept;

    @Test
    void contextLoads() {
        System.out.println(dept);
    }

}

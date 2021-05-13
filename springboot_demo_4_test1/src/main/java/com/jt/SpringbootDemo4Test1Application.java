package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jt.mapper")
public class SpringbootDemo4Test1Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo4Test1Application.class, args);
    }

}

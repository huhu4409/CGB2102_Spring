package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@MapperScan("com.jt.mapper")
public class SpringbootDemo2TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo2TestApplication.class, args);
    }

}

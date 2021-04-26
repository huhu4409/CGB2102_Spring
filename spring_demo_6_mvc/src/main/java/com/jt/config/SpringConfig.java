package com.jt.config;

import com.jt.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration      //标识我是一个配置类 相当于application.xml
@ComponentScan("com.jt")//如果注解中只有一个value，可以省略
@PropertySource(value = "classpath:/user.properties",encoding = "UTF-8")   //@PropertySource() 作用：加载指定的property配置文件 将数据保存到Spring容器中
public class SpringConfig {
    /*定义对象属性 准备接收数据
    * @Value(123) 将123值赋值给id
    * @Value("${user.id}") 在spring容器中查找key=user.id的数据，通过${}进行查找
    * */
    @Value("${user.id}")
    private Integer id;
    @Value("${user.username}")
    private String username;

    /*Spring <bean id="" class=""/>
    * 执行@Bean标识的方法，将方法名作为id，返回值的对象当做value，直接保存到Map集合中*/
    @Bean
    public User user(){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }
}

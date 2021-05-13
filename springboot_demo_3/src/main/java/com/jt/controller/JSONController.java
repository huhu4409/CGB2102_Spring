package com.jt.controller;

import com.jt.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController     //@ResponseBody+@Controller 该类中所有的方法的返回值都是JSON
public class JSONController {

    /**
     * 需求: 要求根据getJSON的请求,获取User对象的JSON数据.
     * 用法: 如果需要返回JOSN数据则使用注解@ResponseBody
     * 知识点讲解:
     *      返回的对象之后,SpringMVC通过内部API(ObjectMapper)
     *      调用对象的getXXX()方法动态的获取属性和属性值.
     *  演化规则:
     *      getAge() ~~~~~去掉get首字母~~~~~Age()
     *      ~~~~~~首字母小写~~~~~age()~~~~获取属性age
     *      ~~~~~通过getAge() 动态获取属性的值
     *
     *  JSON: {"age": "今年18岁!!!"}
     *  注意事项:
     *      必须添加get/set方法
     */
   @RequestMapping("/getJSON")
//    @ResponseBody   //返回值就是一个JSON串
    public User getJSON(){
        User user = new User();
        user.setId(1086).setName("你好");
        return user;
    }
}

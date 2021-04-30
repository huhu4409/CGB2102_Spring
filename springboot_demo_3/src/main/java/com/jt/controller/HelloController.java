package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//将该类交给spring容器管理，同时开启spring mvc机制
public class HelloController {
    /**需求：http://localhost:8090/hello 访问hello.html
     * 实现步骤：
     *      1.拦截用户请求 @requestMapping("/hello")
     *      2.string类型的返回值 表示返回页面名称
     *      3.根据yml配置文件的内容 动态的拼接前缀和后缀，形成页面唯一路径
     */
    @RequestMapping("/hello")
    public String hello(){
        //动态拼接前缀prefix后缀suffix
        return "hello";
    }
}

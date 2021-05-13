package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FindController {
    /**
     * 测试转化和重定向
     *   1.准备一个请求 findUser请求.
     *   2.要求通用转发到 findDog请求中.
     *
     *   3.关键字   forward: 转发的是一个请求.....
     *             redirect: 多次请求多次响应
     *   4.特点:
     *      1.转发时 会携带用户提交的数据.
     *      2.转发时 用户浏览器的地址不会发生改变.
     *      3.重定向时  由于是多次请求,所以不会携带用户的数据
     *      4.重定向时  由于是多次请求,所以用户的浏览器的地址会发生变化
     *
     * 5.实际意义：实现了方法内的松耦合
     * 6.什么时候使用转发、什么时候使用重定向
     *    1.如果携带参数 使用转发
     *    2.如果一个业务已经完成需要一个新的开始，则使用重定向*/
    @RequestMapping("/findUser")
    public String findUser(String name){
        //return "forward:/findDog";    //转发到findDog请求
        return "redirect:/findDog";     //重定向到findDog请求
    }

    @RequestMapping("/findDog")
    public String findDog(String name, Model model){
        name = name + "旺旺旺！！！！";
        model.addAttribute("name",name);
        return "dog";
    }
}

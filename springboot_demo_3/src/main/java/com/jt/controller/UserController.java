package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    /**使用对象的方式接收数据
     URL地址：/addUser url参数：id:name:hobby：游泳 hobby：游戏 hobby：敲代码
     对象赋值的原理：
     要求：P0J0对象中必须有get/set方法
     1.当用户提交数据之后，利用对象的set方法为属性赋值。*/
    @RequestMapping("user/addUser")
    public String addUser(User user){
        service.addUser(user);
        return "success";
    }

    /**
     * 同名提交测试
     * url参数：id:name:  hobbys：游泳 hobbys：游戏 hobbys：敲代码
     * 参数提交的形式：springMVC自动的将参数进行了","号拼接游泳,游戏，敲代码
     * SpringMvc优t：
     * 1.可以根据号自动的将字符串进行拆分
     * 2.如果数据类型不是string类型，则可以自动的转化总结：如果以后遇到了同名提交问题，
     * 则使用数组或者可变参数类型接收string... hobby 可变参数类型实质就是数组
     * @param id
     * @param name
     * @param hobby
     * @return
     */
    //@RequestMapping("user/addUser")
    public String addUser(Integer id,String name,String[] hobby){
        System.out.println("参数:" + id + ":" + name + ":" + Arrays.toString(hobby));
        return "success";
    }

    /*测试@RequestParam注解 参数说明：
    *   1.name/value  接收参数的名称
    *   2.required 默认值true 该数据项为必填项 防止空值
    *   3.defaultValue 设定数据默认值 如果参数为null则设定默认值*/
    /*@RequestMapping("/user/addUser")
    public String addUser(
            @RequestParam(value = "id",required = true,defaultValue = "1101") Integer id ,
            @RequestParam(value = "name",required = true,defaultValue = "你好") String name){
        System.out.println("参数:" + id + ":" + name);
        return "success";
    }*/

    /**mvc底层数据传输原则
     * url:http://localhost:8090/user
     * ModelAndView
     *  1.model 封装数据的
     *  2.view 封装视图页面的
     *
     * */
    @RequestMapping("/user")
    public String toUser(Model model){
        model.addAttribute("id", 10023);
        model.addAttribute("name", "大风吹，大风吹");
        return "user";
    }
    /*public ModelAndView toUser(){
        ModelAndView modelAndView = new ModelAndView();
        //封装数据
        modelAndView.addObject("id", 1001);
        modelAndView.addObject("name", "桃花");
        //封装页面数据
        modelAndView.setViewName("/user");
        return modelAndView;

    }*/

    /*@RequestMapping("/user/addUser")
    public String addUser(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        System.out.println("参数：" + id +":" + name);
        return "success";
    }*/
    //@RequestMapping("/user/addUser")
    public String addUser(String id,String name){
        System.out.println("参数：" + id +":" + name);
        return "success";
    }
}

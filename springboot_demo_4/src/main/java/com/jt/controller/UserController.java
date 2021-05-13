package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/userAjax")
    public String userAjax(){
        return "userAjax";
    }

    @RequestMapping("/findAjaxUser")
    @ResponseBody
    public List<User> findAjaxUser(){
        return userService.findAll();
    }



    @RequestMapping("/demo")
    @ResponseBody
    public String demo(){
        return "框架整合mybatisplus";
    }

    /**
     * 查询所有的用户列表数据，在userList.html展现数据
     */
    @RequestMapping("/userList")
    public String userList(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("userList",userList);
        return "userList";
    }


    @RequestMapping("/user/{name}/{age}/{sex}")
    public String insertUser(User user){
        userService.insertUser(user);
        return "redirect:/userList";
    }

    /**
     * 需求一：利用restFul实现用户修改
     *         之后重定向到userList.html
     *         url地址:/user/id/name*/
    @RequestMapping("/user/{id}/{name}")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/userList";
    }


    /**
     * 需求2：利用restFul实现数据删除
     *        url:/user/100(id)
     *        之后重定向到userList.html*/
    @RequestMapping("/user/{id}")
    public String delUser(@PathVariable Integer id){
        userService.delUserById(id);
        return "redirect:/userList";
    }
}

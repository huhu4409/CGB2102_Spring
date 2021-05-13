package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/findAllUser")
    @ResponseBody
    public List<User> findAllUser(Model model){
        return userService.findAllUser();
    }

    @RequestMapping("/updateUserInfo")
    public String updateUser(User user){
        userService.updateUser(user);
        return "userAjax";
    }

    @RequestMapping("/delUser")
    public String delUser(User user){
        userService.delUser(user);
        return "userAjax";
    }
}

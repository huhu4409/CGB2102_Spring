package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public String userList(){
        return "userList";
    }

    @GetMapping("/user/findAll")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAll();
    }

    @PostMapping("/user/insertUser/{name}/{age}/{sex}")
    public String insertUser(User user){
        userService.insertUser(user);
        return "redirect:/user";
    }

    @PostMapping("/user/updateUser")
    @ResponseBody
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/user/deleteUser")
    @ResponseBody
    public void deleteUser(Integer id){
        userService.deleteUserById(id);
    }
}

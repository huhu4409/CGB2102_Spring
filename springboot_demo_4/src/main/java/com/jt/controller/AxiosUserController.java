package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//返回值为JSON格式
@CrossOrigin//跨域
public class AxiosUserController {
    @Autowired
    private UserService userService;

    @GetMapping("/AxiosUser/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }

    @PutMapping("/AxiosUser/updateUser")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/AxiosUser/delUser")
    public void delUser(Integer id){
        userService.delUserById(id);
    }
}

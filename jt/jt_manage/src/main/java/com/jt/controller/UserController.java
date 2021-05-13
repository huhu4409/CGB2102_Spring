package com.jt.controller;

import com.jt.pojo.User;
import com.jt.service.UserService;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 1.url地址：/user/login
     * 2.请求参数：表单独享的JSON串  POST类型
     * 3.返回值结果 SysResult
     */
    @PostMapping("/login")
    public SysResult login(User user){
        String token = "1223456666";
        return SysResult.success(token);
    }
}

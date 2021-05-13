package com.jt.controller;

import com.jt.pojo.Axios;
import org.springframework.web.bind.annotation.*;

//接收前端发送的axios请求
@RestController
@CrossOrigin    //允许当前类中的所有方法执行跨域操作
public class AxiosController {
    @GetMapping("/getAxios")
    public String getAxios(){
        return "你只能带走的只有自己和自己的脾气";
    }

    @GetMapping("/getAxiosParam/{id}")
    public String getAxiosParam(@PathVariable Integer id){
        return "你只能带走的只有自己和自己的脾气" + id;
    }

    @GetMapping("/getAxiosParams")
    public String getAxiosParams(Integer id){
        return "你只能带走的只有自己和自己的脾气" + id;
    }

    /**动态接收post请求 并且接收JSON格式的参数
     *  RequestBody:将请求中JSON格式的数据转化为对象
     *  ResponseBody:将相应中的对象转化为JSON格式的数据
     */
    @PostMapping("/addParam")
    public Axios addParam(@RequestBody Axios axios){
        return axios;
    }

    //利用Form表单接受数据
    //id:100  name：tomcat猫  可以使用对象接受参数
    @PostMapping("/addParamForm")
    public Axios addParamForm(Axios axios){
        return axios;
    }
}

package com.jt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestFulController {

    /**
     * 常规get请求:
     * url地址: http://localhost:8090/restFul?id=1&name=tom
     * get请求弊端: 如果参数有多个,则key-value的结构需要多份.
     * RestFul结构:
     *  url地址: http://localhost:8090/restFul/{id}/{name}
     *      1.参数之间使用/分割
     *      2.参数的位置一旦确定,不可更改
     *      3.参数使用{}号的形式进行包裹,并且设定形参
     *      4.在接收参数时,使用特定的注解取值@PathVariable
     *
     * @PathVariable: 参数说明
     *      1.name/value  动态接收形参的数据  如果参数相同则省略不写
     *      2.必填项 required 默认为true
     */
    //@RequestMapping(value = "/restFul/{id}/{name}",method = RequestMethod.GET)
    //@RequestMapping(value = "/restFul/{id}/{name}",method = RequestMethod.POST)
    //@RequestMapping(value = "/restFul/{id}/{name}",method = RequestMethod.PUT)
    //@RequestMapping(value = "/restFul/{id}/{name}",method = RequestMethod.DELETE)
    @GetMapping("/restFul/{id}/{name}")
    //@DeleteMapping("/restFul/{id}/{name}")
    //@PutMapping("/restFul/{id}/{name}")
    //@PostMapping("/restFul/{id}/{name}")
    //@RequestMapping("/restFul/{id}/{name}") //默认支持所有的请求类型
    @RequestMapping("/restFul/{id}/{name}")
    public String restFul(@PathVariable Integer id,
                          @PathVariable String name){
        System.out.println("获取参数:" + id + " " + name);
        return "restFul";
    }
}

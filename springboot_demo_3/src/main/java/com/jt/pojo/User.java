package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Value;
import lombok.experimental.Accessors;

import java.lang.reflect.Type;

//pojo实体对象中必须使用包装类型
//规则说明：1.基本类型有默认值 包装类型默认值为null
//          2.基本类型中没有多余的方法，对后续代码取值有问题
@Data
@Accessors(chain = true)
@TableName("user")
public class User {

    //页面name属性 id(主键)/name/hobby
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String hobby;
    private String dogId;
    private String dogName;
}

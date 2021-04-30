package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
//1.如果没有添加注解的属性，默认以类名(DemoUser)当做表名(demo_user)
@TableName("demo_user")//对象与表绑定
public class DemoUser {
    @TableId(type = IdType.AUTO)    //定义主键自增
    //@TableId(type = IdType.ASSIGN_UUID) //UUID随机hash算法，几乎保证不重复
    private Integer id;
    //@TableField(value = "name",exist = true) 属性没有特殊需求也就是名称可以不写，
    //exist为数据是否存在该字段，默认为true存在
    private String name;
    private Integer age;
    private String sex;
}

package com.jt.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

//pojo实体对象中必须使用包装类型
//规则说明：1.基本类型有默认值 包装类型默认值为null
//          2.基本类型中没有多余的方法，对后续代码取值有问题
@Data
@Accessors(chain = true)
@Tablename("user")
public class User {

    //页面name属性 id/name/hobby
    private Integer id;
    private String name;
    private String hobby;
    private String dogId;
    private String dogName;
}

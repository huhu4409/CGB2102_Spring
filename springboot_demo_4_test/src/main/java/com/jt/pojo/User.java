package com.jt.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@TableName("demo_user")
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String age;
    private String sex;
}

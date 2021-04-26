package com.jt.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*自定义注解 包括元注解
注解的作用： 配合AOP进行注解类型 案例的训练   标识
控制注解的生命周期
*/
@Retention(RetentionPolicy.RUNTIME)//控制注解的生命周期
//注解的作用对象  方法有效  类有效 TYPE
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
public @interface Cache {
}
